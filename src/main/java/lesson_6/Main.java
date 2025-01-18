package lesson_6;

public class Main {
    public static void main(String[] args){
        String[][] array = {{"1", "2", "4", "6"}, {"2", "а", "2", "8"}, {"10", "5", "1", "7"}, {"1", "4", "1", "7"}};

        try{
            int sum = ArrayHandler.arrayProcessing(array);
            System.out.println("Сумма массива равна " + sum);

        } catch(MyArraySizeException e){
            System.out.println("ArraySizeException " + e.getMessage());

        }catch (MyArrayDataException e){
            System.out.println("ArrayDataException " + e.getMessage() + "["+ e.getRow() + "]" + "[" + e.getColumn() + "] ");
        }
    }
}
