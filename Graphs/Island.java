//Given a boolean 2D matrix, find the number of islands. 
//A group of connected 1s forms an island.

package graphs;

public class Island {

	public static int islands(int[][] mat) {
		boolean[][] taken = new boolean[mat.length][mat[0].length];
		int count = 0;
		
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat[0].length; j++) {
				if(mat[i][j] == 1 && !taken[i][j]) {
					islandUtil(mat, i, j, taken);
					count++;
					System.out.println("====== Island "+count+" till here ========");
				}
			}
		}
		return count;
	}
	
	public static boolean islandUtil(int[][] mat, int row, int col, boolean[][] taken) {
		if(isSafe(mat, row, col, taken)) {
			System.out.println("Current r, c: "+row+","+col);
			taken[row][col] = true;
			
			if(islandUtil(mat, row + 1, col, taken))
				return true;
			if(islandUtil(mat, row, col + 1, taken))
				return true;
			if(islandUtil(mat, row + 1, col + 1, taken))
				return true;
			if(islandUtil(mat, row - 1, col + 1, taken))
				return true;
			if(islandUtil(mat, row + 1, col -1, taken))
				return true;
		}
		
		return false;
	}
	
	private static boolean isSafe(int[][] mat, int row, int col, boolean[][] taken) {
		if(row >= 0 && col >= 0 && row <= mat.length - 1 && col <= mat[0].length - 1 && mat[row][col] == 1 && !taken[row][col])
			return true;
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = { {1, 1, 0, 0, 0},
		                {0, 1, 0, 0, 1},
		                {1, 0, 0, 1, 1},
		                {0, 0, 0, 0, 0},
		                {1, 0, 1, 0, 1} };

		System.out.println("Number of islands: "+islands(mat));
		
	}

}
