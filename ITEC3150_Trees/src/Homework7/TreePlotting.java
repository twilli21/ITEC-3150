package Homework7;



public class TreePlotting {
	private BSTMapNode overallRoot;

	public TreePlotting(BSTMapNode root) {
	  overallRoot = root;
	}

	public String toString() {
		int size   = __getSize();
		int height = __getHeight();
		int widest = __getWidest() + 1;

		//BSTMapNode.clearCycleData(20);
		String result = toString(overallRoot, 0, 0, size, height, widest);

		if (overallRoot == null) {
			result = "overallRoot\n   null";
		} else {
			String firstLine = "";
			int nodesLeft = __getSize(overallRoot.getLeft());
			int spaces = (nodesLeft * widest) - Math.max(0, "overallRoot".length() - widest + 1) / 2;
			for (int i = 0; i < spaces; i++) {
				firstLine += " ";
			}
			firstLine += "overallRoot\n";

			int len = result.length();
			while (len < firstLine.length()) {
				result = " " + result;
				len += 2;
			}

			result = firstLine + result;
		}

		return result;
	}

	private String toString(BSTMapNode root, int sizeAboveLeft, int level, 
			int size, int height, int width) {
		// System.out.println("toString(root, " + sizeAboveLeft + ", " + level + ", " + size + ", " + height + ", " + width + ")");
		if (root == null) {
			return "";
		} else {
			String result = "";
			int sizeBelowLeft = __getSize(root.getLeft());
			int sizeLeft = sizeAboveLeft + sizeBelowLeft;

			// create line for this element
			// (must potentially put leading __ marks for left/right pointers)
			String thisElementLine = "";
			String nextLine = "";

			if (root.getLeft() == null) {
				// indent this node
				for (int i = 0; i < width * sizeAboveLeft; i++) {
					thisElementLine += " ";
					if (root.getRight() != null) {
						nextLine += " ";
					}
				}
			} else {
				// indent this node, but insert / and _____ for left pointer
				int widthOfLeft = root.getLeft().toString().length();
				int dWidthLeft = width - widthOfLeft;

				int betweenLeft = __getSizeBetweenLeft(root);
				for (int i = 0; i < width * (sizeLeft - betweenLeft) - dWidthLeft; i++) {
					thisElementLine += " ";
					nextLine += " ";
				}
				thisElementLine += " ";
				nextLine += "/";
				for (int i = 0; i < width * betweenLeft - 1 + dWidthLeft; i++) {
					thisElementLine += "_";
					if (root.getRight() != null) {
						nextLine += " ";
					}
				}
			}

			thisElementLine += root;

			if (root.getRight() != null) {
				// insert _____ and \ for right pointer
				for (int i = 0; i < root.toString().length(); i++) {
					nextLine += " ";
				}

				for (int i = 0; i < width - root.toString().length() - 1; i++) {
					thisElementLine += "_";
					nextLine += " ";
				}

				int betweenRight =  __getSizeBetweenRight(root);
				for (int i = 0; i < width * betweenRight; i++) {
					thisElementLine += "_";
					nextLine += " ";
				}
				nextLine += "\\";
			}

			if (root.getLeft() == null && root.getRight() == null) {
				result += thisElementLine;
			} else {
				thisElementLine += "\n";
				nextLine += "\n";

				// append all left elements
				String leftLines = toString(root.getLeft(), sizeAboveLeft, level + 1, size, height, width);

				// append all right elements
				String rightLines = toString(root.getRight(), sizeLeft + 1, level + 1, size, height, width);

				result += thisElementLine + nextLine + mergeLines(leftLines, rightLines);
			}

			return result;
		}
	}

	private String mergeLines(String left, String right) {
		String[] leftLines  = left.split("\n");
		String[] rightLines = right.split("\n");

		String[] resultLines = new String[Math.max(leftLines.length, rightLines.length)];
		for (int i = 0; i < resultLines.length; i++) {
			if (i >= rightLines.length) {
				resultLines[i] = leftLines[i];
			} else if (i >= leftLines.length) {
				resultLines[i] = rightLines[i];
			} else {
				resultLines[i] = leftLines[i];
				if (rightLines[i].length() > leftLines[i].length()) {
					resultLines[i] += rightLines[i].substring(leftLines[i].length());
				}
			}
		}

		String result = "";
		for (String line : resultLines) {
			if (result.length() > 0) {
				result += "\n";
			}
			result += line;
		}
		return result;
	}

	private int __getSizeBetweenLeft(BSTMapNode root) {
		if (root == null || root.getLeft() == null) {
			return 0;
		} else {
			return __getSize(root.getLeft().getRight());
		}
	}

	private int __getSizeBetweenRight(BSTMapNode root) {
		if (root == null || root.getRight() == null) {
			return 0;
		} else {
			return __getSize(root.getRight().getLeft());
		}
	}

	private int __getHeight() {
		
		return __getHeight(overallRoot);
	}

	private int __getHeight(BSTMapNode root) {
		if (root == null) {
			return 0;
		} else {
			int leftHeight = 0;
			BSTMapNode left = root.getLeft();
			if (left != null ) {
				leftHeight = __getHeight(left);
			}
			int rightHeight = 0;
			BSTMapNode right = root.getRight();
			if (right != null ) {
				rightHeight = __getHeight(right);
			}
			return 1 + Math.max(leftHeight, rightHeight);
		}
	}

	private int __getSize() {
		
		return __getSize(overallRoot);
	}

	private int __getSize(BSTMapNode root) {
		if (root == null) {
			return 0;
		} else {
			int leftSize = 0;
			BSTMapNode left = root.getLeft();
			if (left != null) {
				leftSize = __getSize(left);
			}
			int rightSize = 0;
			BSTMapNode right = root.getRight();
			if (right != null) {
				rightSize = __getSize(right);
			}
			return 1 + leftSize + rightSize;
		}
	}

	private int __getWidest() {
		
		return __getWidest(overallRoot);
	}

	private int __getWidest(BSTMapNode root) {
		if (root == null) {
			return 0;
		} else {
			int width = root.toString().length();
			int widestLeft = 0;
			BSTMapNode left = root.getLeft();
			if (left != null) {
				widestLeft = __getWidest(left);
			}
			int widestRight = 0;
			BSTMapNode right = root.getRight();
			if (right != null ) {
				widestRight = __getWidest(right);
			}
			return Math.max(width, Math.max(widestLeft, widestRight));
		}
	}
}