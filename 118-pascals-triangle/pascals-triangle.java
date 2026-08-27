class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        for(int row = 1; row <= numRows; row++){
            pascalTriangle.add(generateRow(row));
        }

        return pascalTriangle;
    }

    public List<Integer> generateRow(int row){
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1);

        long ans = 1;        

        for(int col = 1; col < row; col++){
            ans *= (row - col);
            ans /= col;
            ansRow.add((int) ans);
        }

   

        return ansRow;
    }
}