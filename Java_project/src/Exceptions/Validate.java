package Exceptions;

import Models.AnimalsClasses.Animal;

import java.time.LocalDate;
import java.util.List;

public class Validate {
    public void checkString(String text) throws Exception {
        if (text.isEmpty()) {
            throw new EmptyInputException("ERROR! The field can not be empty!");
        } else if (text.length() == 1) {
            throw new LengthException("ERROR! The length is too short!");
        } else if (text.matches("[0-9]+")) {
            throw new IntException("ERROR! The field can not consist only of digits!");
        }
    }

    public void checkDateFormat(String date) throws Exception {
        if (!date.matches("\\d{1,2}\\.\\d{1,2}\\.\\d{4}")) {
            throw new DateFormatException("ERROR! Incorrect date format!");
        }
    }

    public void checkBirthday(String birthday) throws Exception {
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int startYear = currentYear - 50;

        String[] splitDate = birthday.split("\\.");

        if (Integer.parseInt(splitDate[2]) < startYear || Integer.parseInt(splitDate[2]) > currentYear) {
            throw new DateException("ERROR! The birth year is incorrect!");
        }
        if (Integer.parseInt(splitDate[1]) < 1 || Integer.parseInt(splitDate[1]) > 12) {
            throw new DateException("ERROR! The month is incorrect!");
        } else {
            if (Integer.parseInt(splitDate[0]) < 1 || Integer.parseInt(splitDate[0]) > 31) {
                throw new DateException("ERROR! The date is incorrect!");
            } else {
                if (Integer.parseInt(splitDate[1]) == 4 || Integer.parseInt(splitDate[1]) == 6 ||
                        Integer.parseInt(splitDate[1]) == 9 || Integer.parseInt(splitDate[1]) == 11) {
                    if (Integer.parseInt(splitDate[0]) == 31) {
                        throw new DateException("ERROR! The date is incorrect!");
                    }
                } else if (Integer.parseInt(splitDate[1]) == 2 && Integer.parseInt(splitDate[2]) % 4 != 0) {
                    if (Integer.parseInt(splitDate[0]) > 28) {
                        throw new DateException("ERROR! The date is incorrect!");
                    }
                }
            }
        }
    }

    public void searchAnimal(List<Animal> animals) throws Exception {
        if (animals.size() == 0) {
            throw new Exception("ERROR! Animal not found!");
        }
    }
}
