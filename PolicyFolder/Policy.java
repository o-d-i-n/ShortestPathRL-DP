package PolicyFolder;
import PolicyFolder.ValueFunctionFolder.*;
public class Policy{
	private static final int NORTH = 1,EAST = 2,WEST = 4,SOUTH = 8;
	private int[][] policyMatrix;
	
	private int row,col; 
	public Policy(int row, int col,int[] goal){
		this.row = row;
		this.col = col;
		this.policyMatrix = new int[this.row][this.col];
		for(int i=0;i<this.row;i++)
			for(int j=0;j<this.col;j++)
				this.policyMatrix[i][j] = NORTH + EAST + WEST + SOUTH;
		

		for(int i=0; i<goal.length-1;i+=2){
			this.policyMatrix[goal[i]][goal[i+1]] = 0;
		}
	}
	public void copy(int[][] newPolicyMatrix){
		for(int i=0;i<this.row;i++)
			for(int j=0;j<this.col;j++)
				this.policyMatrix[i][j] = newPolicyMatrix[i][j];
	}
	public void updatePolicy(ValueFunction valueMatrix){
		for(int i=0;i<this.row;i++)
			for(int j=0;j<this.col;j++){
				if(this.policyMatrix[i][j]!=0){
					double greatest;
					if( i == 0)
						greatest = valueMatrix.stateValue(i+1,j);
					else
						greatest = valueMatrix.stateValue(i-1,j);
					if(i==0){
						if(j==0){
							if(valueMatrix.stateValue(i,j+1) > greatest)
								greatest = valueMatrix.stateValue(i,j+1);
							if(valueMatrix.stateValue(i+1,j) > greatest)
								greatest = valueMatrix.stateValue(i+1,j);
								this.policyMatrix[i][j] = 0;
							if(valueMatrix.stateValue(i,j+1) == greatest)
								this.policyMatrix[i][j]+= EAST;
							if(valueMatrix.stateValue(i+1,j) == greatest)
								this.policyMatrix[i][j]+= SOUTH;

						} else if(j == this.col-1){
							if(valueMatrix.stateValue(i,j-1) > greatest)
								greatest = valueMatrix.stateValue(i,j-1);
							if(valueMatrix.stateValue(i+1,j) > greatest)
								greatest = valueMatrix.stateValue(i+1,j);
							policyMatrix[i][j] = 0;
							if(valueMatrix.stateValue(i,j-1) == greatest)
								this.policyMatrix[i][j]+= WEST;
							if(valueMatrix.stateValue(i+1,j) == greatest)
								this.policyMatrix[i][j]+= SOUTH;

						} else{
							if(valueMatrix.stateValue(i,j-1) > greatest)
								greatest = valueMatrix.stateValue(i,j-1);
							if(valueMatrix.stateValue(i+1,j) > greatest)
								greatest = valueMatrix.stateValue(i+1,j);
							if(valueMatrix.stateValue(i,j+1) > greatest)
								greatest = valueMatrix.stateValue(i,j+1);
							this.policyMatrix[i][j] = 0;
							if(valueMatrix.stateValue(i,j-1) == greatest)
								this.policyMatrix[i][j]+= WEST;
							if(valueMatrix.stateValue(i+1,j) == greatest)
								this.policyMatrix[i][j]+= SOUTH;
							if(valueMatrix.stateValue(i,j+1) == greatest)
								this.policyMatrix[i][j]+= EAST;
						}
					} else if(i == this.row-1){
						if(j==0){
							if(valueMatrix.stateValue(i,j+1) > greatest)
								greatest = valueMatrix.stateValue(i,j+1);
							if(valueMatrix.stateValue(i-1,j) > greatest)
								greatest = valueMatrix.stateValue(i-1,j);
							this.policyMatrix[i][j] = 0;
							if(valueMatrix.stateValue(i,j+1) == greatest)
								this.policyMatrix[i][j]+= EAST;
							if(valueMatrix.stateValue(i-1,j) == greatest)
								this.policyMatrix[i][j]+= NORTH;
						} else if(j == this.col-1){
							if(valueMatrix.stateValue(i,j-1) > greatest)
								greatest = valueMatrix.stateValue(i,j-1);
							if(valueMatrix.stateValue(i-1,j) >greatest)
								greatest = valueMatrix.stateValue(i-1,j);
							this.policyMatrix[i][j] = 0;
							if(valueMatrix.stateValue(i,j-1) == greatest)
								this.policyMatrix[i][j]+= WEST;
							if(valueMatrix.stateValue(i-1,j) == greatest)
								this.policyMatrix[i][j]+= NORTH;
						} else{
							if(valueMatrix.stateValue(i,j+1) > greatest)
								greatest = valueMatrix.stateValue(i,j+1);
							if(valueMatrix.stateValue(i-1,j) > greatest)
								greatest = valueMatrix.stateValue(i-1,j);
							if(valueMatrix.stateValue(i,j-1) > greatest)
								greatest = valueMatrix.stateValue(i,j-1);
							this.policyMatrix[i][j] = 0;
							if(valueMatrix.stateValue(i,j+1) == greatest)
								this.policyMatrix[i][j]+= EAST;
							if(valueMatrix.stateValue(i-1,j) == greatest)
								this.policyMatrix[i][j]+= NORTH;
							if(valueMatrix.stateValue(i,j-1) == greatest)
								this.policyMatrix[i][j]+= WEST;
						}
					} else if(j==0){
						if(valueMatrix.stateValue(i,j+1) > greatest)
							greatest = valueMatrix.stateValue(i,j+1);
						if(valueMatrix.stateValue(i-1,j) > greatest)
							greatest = valueMatrix.stateValue(i-1,j);
						if(valueMatrix.stateValue(i+1,j) > greatest)
							greatest = valueMatrix.stateValue(i+1,j);
							this.policyMatrix[i][j] = 0;
						if(valueMatrix.stateValue(i,j+1) == greatest)
							this.policyMatrix[i][j]+= EAST;
						if(valueMatrix.stateValue(i-1,j) == greatest)
							this.policyMatrix[i][j]+= NORTH;
						if(valueMatrix.stateValue(i+1,j) == greatest)
							this.policyMatrix[i][j]+= SOUTH;
					} else if(j==this.col-1){
							
						if(valueMatrix.stateValue(i-1,j) > greatest)
							greatest = valueMatrix.stateValue(i-1,j);
						if(valueMatrix.stateValue(i,j-1) > greatest)
							greatest = valueMatrix.stateValue(i,j-1);
						if(valueMatrix.stateValue(i+1,j) > greatest)
							greatest = valueMatrix.stateValue(i+1,j);
						this.policyMatrix[i][j] = 0;
						
						if(valueMatrix.stateValue(i-1,j) == greatest)
							this.policyMatrix[i][j]+= NORTH;
						if(valueMatrix.stateValue(i,j-1) == greatest)
							this.policyMatrix[i][j]+= WEST;
						if(valueMatrix.stateValue(i+1,j) == greatest)
							this.policyMatrix[i][j]+= SOUTH;
					}
					else{
						if(valueMatrix.stateValue(i,j+1) > greatest)
							greatest = valueMatrix.stateValue(i,j+1);
						if(valueMatrix.stateValue(i-1,j) > greatest)
							greatest = valueMatrix.stateValue(i-1,j);
						if(valueMatrix.stateValue(i,j-1) > greatest)
							greatest = valueMatrix.stateValue(i,j-1);
						if(valueMatrix.stateValue(i+1,j) > greatest)
							greatest = valueMatrix.stateValue(i+1,j);
						this.policyMatrix[i][j] = 0;
						if(valueMatrix.stateValue(i,j+1) == greatest)
							this.policyMatrix[i][j]+= EAST;
						if(valueMatrix.stateValue(i-1,j) == greatest)
							this.policyMatrix[i][j]+= NORTH;
						if(valueMatrix.stateValue(i,j-1) == greatest)
							this.policyMatrix[i][j]+= WEST;
						if(valueMatrix.stateValue(i+1,j) == greatest)
							this.policyMatrix[i][j]+= SOUTH;
					}
				}
			}
		
	}
	public void printPolicy(){
		for(int i=0; i<this.row;i++){
			for(int j=0;j<this.col;j++)
				System.out.print(this.policyMatrix[i][j] + "\t");
			System.out.println();
		}
	}
	public void printConvertedPolicy(){
		for(int i=0; i<this.row;i++){
			for(int j=0;j<this.col;j++){
				int placeholder = this.policyMatrix[i][j];
				if(placeholder != 0){
					if(placeholder >=8){
					placeholder-=8;
					System.out.print("S");
					}
					if(placeholder >= 4){
						placeholder-=4;
						System.out.print("W");
					}
					if(placeholder>=2){
						placeholder-=2;
						System.out.print("E");
					}
					if(placeholder>=1){
						placeholder-=1;
						System.out.print("N");
					}
				}
				else{
					System.out.print("G");
				}
				System.out.print("\t");
			}
			
			System.out.println();
		}
	}
	
	public int[][] returnPolicyMatrix(){
		return this.policyMatrix;
	}
	public boolean equals(Policy policy){
		int[][] policyMatrix = policy.returnPolicyMatrix();
		boolean retVal = true;
		for(int i=0;i<this.row;i++){
			for(int j=0;j<this.col;j++){
				if(policyMatrix[i][j] != this.policyMatrix[i][j])
					retVal = false;
			}
		}
		return retVal;
	}
}
