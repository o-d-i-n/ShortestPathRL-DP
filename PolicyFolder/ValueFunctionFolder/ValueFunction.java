package PolicyFolder.ValueFunctionFolder;
import java.util.*;
public class ValueFunction{
	private double[][] valueMatrix;
	private int row, col;
	
	public ValueFunction(int row, int col,int[] goal){
		this.row = row;
		this.col = col;
		this.valueMatrix = new double[row][col];
		for(int i = 0;i < this.row; i++)
			for(int j=0; j < this.col; j++)
				this.valueMatrix[i][j] = -1.0;
		for(int i=0; i<goal.length-1;i+=2){
			this.valueMatrix[goal[i]][goal[i+1]] = 0.0;
		}	
	}
	public void updateValueMatrix(){
		double[][] newValueMatrix = new double[this.row][this.col];
		for(int i = 0;i < this.row; i++)
			for(int j=0; j < this.col; j++)
				newValueMatrix[i][j] = this.valueMatrix[i][j];
		for(int i = 0;i < this.row; i++){
			for(int j=0; j < this.col; j++){
				if(this.valueMatrix[i][j]!=0.0){
					if(i==0){
						if(j==0){
							newValueMatrix[i][j] = -1 + 0.25 * (this.valueMatrix[i+1][j]  + this.valueMatrix[i][j+1] + this.valueMatrix[i][j] + this.valueMatrix[i][j] );
						}else if(j==this.col-1){
							newValueMatrix[i][j] = -1 + 0.25 * (this.valueMatrix[i+1][j] + this.valueMatrix[i][j-1] + this.valueMatrix[i][j] + this.valueMatrix[i][j]);
						} else{
							newValueMatrix[i][j] = -1 + 0.25 * (this.valueMatrix[i+1][j]  + this.valueMatrix[i][j+1] + this.valueMatrix[i][j-1] + this.valueMatrix[i][j]);
						}
					} else if(i==this.row-1){
						if(j==0){
							newValueMatrix[i][j] = -1 + 0.25 * (this.valueMatrix[i-1][j] + this.valueMatrix[i][j+1] + this.valueMatrix[i][j] + this.valueMatrix[i][j]);
						} else if(j==this.col-1){
							newValueMatrix[i][j] = -1 + 0.25 * (this.valueMatrix[i-1][j]  + this.valueMatrix[i][j-1] + this.valueMatrix[i][j] + this.valueMatrix[i][j]);
						}else{
							newValueMatrix[i][j] = -1 + 0.25 * (this.valueMatrix[i-1][j] + this.valueMatrix[i][j+1] + this.valueMatrix[i][j-1] + this.valueMatrix[i][j]);
						}
					} else if(j==0){
						newValueMatrix[i][j] = -1 + 0.25 * (this.valueMatrix[i+1][j] + this.valueMatrix[i-1][j] + this.valueMatrix[i][j+1] + this.valueMatrix[i][j]);
					} else if(j==this.col-1){
						newValueMatrix[i][j] = -1 + 0.25 * (this.valueMatrix[i+1][j] + this.valueMatrix[i-1][j] + this.valueMatrix[i][j-1] + this.valueMatrix[i][j]);
					} 


					else{
						newValueMatrix[i][j] = -1 + 0.25 * (this.valueMatrix[i+1][j] + this.valueMatrix[i-1][j] + this.valueMatrix[i][j+1] + this.valueMatrix[i][j-1]);
					}
				}
			}
		}
		for(int i = 0;i < this.row; i++)
			for(int j=0; j < this.col; j++)
				this.valueMatrix[i][j] = newValueMatrix[i][j];
	}
	public void printValueFunction(){
		for(int i = 0;i < this.row; i++){
			for(int j=0; j < this.col; j++)
				System.out.print(this.valueMatrix[i][j] + "\t");
			System.out.println();
		}
	}
	public double stateValue(int row, int col){
		return this.valueMatrix[row][col];
	}

}
