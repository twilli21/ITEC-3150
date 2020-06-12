package InClass2_Hash;

import java.util.LinkedList;

public class MyHashMap<K, V> implements MyMap<K, V>
{
	// Define the default hash table size. Must be a power of 2
	private static int DEFAULT_INITIAL_CAPACITY = 4;

	// Define the maximum hash table size. 1 << 30 is same as 2^30
	private static int MAXIMUM_CAPACITY = 1 << 30;

	// Current hash table capacity. Capacity is a power of 2
	private int capacity;

	// Define default load factor
	private static float DEFAULT_MAX_LOAD_FACTOR = 0.75f;

	// Specify a load factor used in the hash table
	private float loadFactorThreshold;

	// The number of entries in the map
	private int size = 0;

	// Hash table is an array with each cell that is a linked list
	LinkedList<MyMap.Entry<K, V>>[] table;

	/** Construct a map with the default capacity and load factor */
	public MyHashMap()
	{
		this(DEFAULT_INITIAL_CAPACITY, DEFAULT_MAX_LOAD_FACTOR);
	}

	/**
	 * Construct a map with the specified initial capacity and default load factor
	 */
	public MyHashMap(int initialCapacity)
	{
		this(initialCapacity, DEFAULT_MAX_LOAD_FACTOR);
	}

	/**
	 * Construct a map with the specified initial capacity and load factor
	 */
	public MyHashMap(int initialCapacity, float loadFactorThreshold)
	{
		if (initialCapacity > MAXIMUM_CAPACITY)
			this.capacity = MAXIMUM_CAPACITY;
		else
			this.capacity = trimToPowerOf2(initialCapacity);

		this.loadFactorThreshold = loadFactorThreshold;
		table = new LinkedList[capacity];
	}

	@Override /** Remove all of the entries from this map */
	public void clear()
	{
		size = 0;
		removeEntries();
	}

	@Override /** Return true if the specified key is in the map */
	public boolean containsKey(K key)
	{
		if (get(key) != null)
			return true;
		else
			return false;
	}

	@Override /** Return true if this map contains the value */
	public boolean containsValue(V value)
	{
		for (int i = 0; i < capacity; i++)
		{
			if (table[i] != null)
			{
				LinkedList<Entry<K, V>> bucket = table[i];
				for (Entry<K, V> entry : bucket)
					if (entry.getValue().equals(value))
						return true;
			}
		}

		return false;
	}

	@Override /** Return a set of entries in the map */
	public java.util.Set<MyMap.Entry<K, V>> entrySet()
	{
		java.util.Set<MyMap.Entry<K, V>> set = new java.util.HashSet<>();

		for (int i = 0; i < capacity; i++)
		{
			if (table[i] != null)
			{
				LinkedList<Entry<K, V>> bucket = table[i];
				for (Entry<K, V> entry : bucket)
					set.add(entry);
			}
		}

		return set;
	}

	@Override /** Return the value that matches the specified key */
	public V get(K key)
	{
		// TODO 1: get bucket index
		int index = hash(key.hashCode());

		// TODO 2: search in the bucket (which is a linked list) for the key.
		// If found, return the value.
		LinkedList<Entry<K, V>> list = table[index];
		if (list != null)
		{
			for (Entry<K, V> e : list)
			{
				if (e.getKey().equals(key))
				{
					return e.getValue();
				}
			}
		}
		// If not found (not returned yet), return null.
		return null;
	}

	@Override /** Return true if this map contains no entries */
	public boolean isEmpty()
	{
		return size == 0;
	}

	@Override /** Return a set consisting of the keys in this map */
	public java.util.Set<K> keySet()
	{
		java.util.Set<K> set = new java.util.HashSet<K>();

		for (int i = 0; i < capacity; i++)
		{
			if (table[i] != null)
			{
				LinkedList<Entry<K, V>> bucket = table[i];
				for (Entry<K, V> entry : bucket)
					set.add(entry.getKey());
			}
		}

		return set;
	}

	@Override /** Add an entry (key, value) into the map */
	public V put(K key, V value)
	{
		if (get(key) != null)
		{ // The key is already in the map
			// TODO 1: get bucket index
			int index = hash(key.hashCode());
			// TODO 2: search in the bucket (which is a linked list) for the key.
			// If found, update the value with the parameter value, return the old value.
			LinkedList<Entry<K, V>> list = table[index];
			if (list != null)
			{
				for (Entry<K, V> e : list)
				{
					if (e.getKey().equals(key))
					{
						V oldValue = e.getValue();
						e.value = value;
						return oldValue;
					}
				}
			}
		}

		// Key not found.

		// Check load factor
		if (size >= capacity * loadFactorThreshold)
		{
			if (capacity == MAXIMUM_CAPACITY)
				throw new RuntimeException("Exceeding maximum capacity");

			rehash();
		}

		// TODO 3: get bucket index
		int index = hash(key.hashCode());
		// TODO 4: Create a linked list for the bucket if it is not created
		if (table[index] == null)
		{
			table[index] = new LinkedList<MyMap.Entry<K, V>>();
		}
		// TODO 5: Add a new entry (key, value) to the bucket (i.e. the linked list)
		table[index].add(new MyMap.Entry<K, V>(key, value));
		// TODO 6: Increase size
		size++;
		return value;
	}

	@Override /** Remove the entries for the specified key */
	public void remove(K key)
	{
		// TODO 1: get bucket index
		int index = hash(key.hashCode());
		// TODO 2: if the bucket is not empty, search
		// for the bucket (a linked list) to find the entry with key matching
		// the given key (paramter), remove the first entry that matches the
		// key from a bucket. Reduce the size by 1.
		LinkedList<Entry<K, V>> list = table[index];
		if (list != null)
		{
			for (Entry<K, V> e : list)
			{
				if (e.getKey().equals(key))
				{
					list.remove(e);
				}
			}
		}
		size--;
	}

	@Override /** Return the number of entries in this map */
	public int size()
	{
		return size;
	}

	@Override /** Return a set consisting of the values in this map */
	public java.util.Set<V> values()
	{
		java.util.Set<V> set = new java.util.HashSet<>();

		for (int i = 0; i < capacity; i++)
		{
			if (table[i] != null)
			{
				LinkedList<Entry<K, V>> bucket = table[i];
				for (Entry<K, V> entry : bucket)
					set.add(entry.getValue());
			}
		}

		return set;
	}

	/** Hash function */
	private int hash(int hashCode)
	{
		return supplementalHash(hashCode) & (capacity - 1);
	}

	// https://www.tutorialspoint.com/Java-Bitwise-Operators
	/** Ensure the hashing is evenly distributed */
	private static int supplementalHash(int h)
	{
		h ^= (h >>> 20) ^ (h >>> 12);
		return h ^ (h >>> 7) ^ (h >>> 4);
	}

	/** Return a power of 2 for initialCapacity */
	private int trimToPowerOf2(int initialCapacity)
	{
		int capacity = 1;
		while (capacity < initialCapacity)
		{
			capacity <<= 1;
		}

		return capacity;
	}

	/** Remove all entries from each bucket */
	private void removeEntries()
	{
		for (int i = 0; i < capacity; i++)
		{
			if (table[i] != null)
			{
				table[i].clear();
			}
		}
	}

	/** Rehash the map */
	private void rehash()
	{
		java.util.Set<Entry<K, V>> set = entrySet(); // Get entries
		capacity <<= 1; // Double capacity
		table = new LinkedList[capacity]; // Create a new hash table
		size = 0; // Reset size to 0

		for (Entry<K, V> entry : set)
		{
			put(entry.getKey(), entry.getValue()); // Store to new table
		}
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder("[");

		for (int i = 0; i < capacity; i++)
		{
			if (table[i] != null && table[i].size() > 0)
				for (Entry<K, V> entry : table[i])
					builder.append(entry);
		}

		builder.append("]");
		return builder.toString();
	}
}