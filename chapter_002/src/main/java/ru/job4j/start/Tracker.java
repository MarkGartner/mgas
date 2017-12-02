package ru.job4j.start;

import ru.job4j.models.*;

import java.util.Random;

public class Tracker {

    private Item[] items = new Item[10];
    private int position = 0;
    private static final Random RN = new Random();

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;

        return item;
    }

    protected void showAllItems(Item[] items) {
        for (Item item : items) {
            this.displayItemInfo(item);
        }
        if (items.length == 0) {
            System.out.println("-----------В трекере нет заявок.------------");
        }
    }

    protected Item findByID(String id) {
        Item result = null;
        for (Item item : this.items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    protected Item editItemByID(String id) {
        Item result = this.findByID(id);
        Input input = new ConsoleInput();
        if (result != null) {
            String name = input.ask("Введите новое имя для заявки: ");
            result.name = name;
            String desc = input.ask("Введите новое описание для заявки: ");
            result.description = desc;
            System.out.println("Данные успешно обновлены.");
        } else if (result == null) {
            System.out.println("---------- Такой заявки не найдено ------------- ");
        }
        return result;
    }


    protected Item findByName(String name) {
        Item result = null;
        for (Item item : this.items) {
            if (item != null && item.name.equals(name)) {
                result = item;
                break;
            }
        }
        return result;
    }
    
    protected void deleteItem(String id) {

        Item itemToDelete = findByID(id);

        if (itemToDelete != null) {
            int toDeleteItemIndex = 0;
            for (int i = 0; i < this.position; i++) {
                if (itemToDelete == this.items[i]) {
                    toDeleteItemIndex = i;
                }
            }
            this.items[toDeleteItemIndex] = null;

            for (int i = toDeleteItemIndex; i < position; i++) {
                this.items[i] = this.items[i + 1];
            }
            position--;
            System.out.println(" ---------------- Заявка " + itemToDelete.getId() + " успешно удалена. --------------------");
        } else {
            System.out.println("------------ Невозможно найти такую заявку. --------------");
        }
    }

    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }


    public Item[] getAll() {
        Item[] result = new Item[this.position];

        for (int index = 0; index < this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }

    public void displayItemInfo(Item item) {

        if (item != null) {
            System.out.println("--------------------------------------------");
            System.out.println("Имя заявки: " + item.name + "\nОписание: " + item.description + "\nID:" + item.getId());
            System.out.println("--------------------------------------------");
        } else {
            System.out.println("--------------------------------------------");
            System.out.println("По данному запросу ничего не найдено.");
            System.out.println("--------------------------------------------");
        }
    }
}
