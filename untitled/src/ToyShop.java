import java.io.*;
import java.util.ArrayList;

import java.util.List;
import java.util.Random;


public class ToyShop {

    private List<Toy> toys;



    public ToyShop() {

        this.toys = new ArrayList<>();

    }



    public void addToy(Toy toy) {

        toys.add(toy);

    }



    public void setToyFrequency(int toyId, double frequency) {

        for (Toy toy : toys) {

            if (toy.getId() == toyId) {

                toy.setFrequency(frequency);

                break;

            }

        }

    }



    public void drawToys() {

        // Вычисляем сумму частот выпадения всех игрушек

        double totalFrequency = 0;

        for (Toy toy : toys) {

            totalFrequency += toy.getFrequency();

        }



        // Генерируем случайное число из диапазона [0, totalFrequency)

        Random random = new Random();

        double randomNumber = random.nextDouble() * totalFrequency;



        // Ищем игрушку, чей интервал частоты выпадения (0 - frequency) содержит случайное число

        double currentFrequency = 0;

        for (Toy toy : toys) {

            currentFrequency += toy.getFrequency();

            if (randomNumber < currentFrequency) {

                System.out.println("Игрушка:" + toy.getName() + " выбрана!");

                break;

            }

        }


    }

    public void setToyQuantity(int toyId, int quantity) {

        for (Toy toy : toys) {

            if (toy.getId() == toyId) {

                toy.setQuantity(quantity);

                break;

            }

        }

    }



    public Toy getToyById(int toyId) {

        for (Toy toy : toys) {

            if (toy.getId() == toyId) {

                return toy;

            }

        }

        return null;

    }



    public Toy getToyByName(String toyName) {

        for (Toy toy : toys) {

            if (toy.getName().equals(toyName)) {

                return toy;

            }

        }

        return null;

    }

    public void saveToys() {

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("toys.txt"))) {

            outputStream.writeObject(toys);

        } catch (IOException e) {

            e.printStackTrace();

        }

    }



    public void loadToys() {

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("toys.txt"))) {

            toys = (List<Toy>) inputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {

            e.printStackTrace();

        }

    }




    // Дополнительные методы для работы с игрушками

    // ...

}