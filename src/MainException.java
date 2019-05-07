public class MainException {

    public static void main(String[] args) {

        String[][] array = new String[][]{{"7", "12", "8", "4", }, {"33", "79", "1", "16"}, {"2", "99", "12", "34"}, {"70", "22", "3", "11"}};
        try {
            try {
                int result = methodException(array);
                System.out.println(result);
            } catch (MyArraySizeException e) {
                System.out.println("Размер массива превышен!");
            }
        }
        catch (MyArrayDataException e) {
            System.out.println("Неправильное значение массива!");
            System.out.println("Ошибка в ячейке: " + e.i + "x" + e.j);
        }

    }


    public static int methodException(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int count = 0;
       // if (array.length != 4) {
            //throw new MyArraySizeException();
       // }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    count = count + Integer.parseInt(array[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }

        }
        return count;
    }

}