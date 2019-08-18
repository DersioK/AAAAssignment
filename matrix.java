
public class matrix {
	public int matrix[][];
	public int r,c;
	public matrix(int v) {
		 this.matrix =new int[v][v];
		for(int i=0;i<v;i++) {
			//System.out.println();
			for(int j=0;j<matrix[i].length;j++){
				matrix[i][j]=0;
				matrix[j][i]=0;
				System.out.print(matrix[i][j]+" ");
				//System.out.print(matrix[r][c]);
			 }
			System.out.println();
		}
		// TODO Auto-generated constructor stub
	}
	
//	public void setXY(int row,int col) {
//       this.r =row;
//       this.c=col;
//	   this.matrix[r][c] = 1;
//       this.matrix[c][r] = 1;
//    }

	

}
