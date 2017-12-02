package ru.job4j.start;

import ru.job4j.models.Item;
import ru.job4j.models.Task;

public class MenuTracker {

    private Input input;
    private Tracker tracker;

    private UserAction[] actions = new UserAction[6];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions[0] = new AddItem();
        this.actions[1] = new ShowAllItens();
        this.actions[2] = new FindByID();
        this.actions[3] = new FindByName();
        this.actions[4] = new EditItembyID();
        this.actions[5] = new MenuTracker.DeleteItem();
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class AddItem implements UserAction {

        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please enter the tasks's name: ");
            String desc = input.ask("Please enter the task's description: ");
            tracker.add(new Task(name, desc));
        }

        @Override
        public String info() {
            return String.format("%s. %s.", this.key(), "Add the new item");
        }
    }

    private class ShowAllItens implements UserAction {

        public int key() {
            return 1;
        }

        public void execute(Input input, Tracker tracker) {
            tracker.showAllItems(tracker.getAll());
        }

        public String info() {
            return String.format("%s. %s.", this.key(), "Show all items");
        }
    }

    private static class FindByID implements UserAction {

        public int key() {
            return 2;
        }

        public void execute(Input input, Tracker tracker) {
            String searchID = input.ask("Please enter ID: ");
            Item result = tracker.findByID(searchID);
            if (result != null) {
                tracker.displayItemInfo(result);
            } else {
                System.out.println("Sorry. No such item exists");
            }
        }

        public String info() {
            return String.format("%s. %s.", this.key(), "Find item by ID");
        }
    }

    private static class FindByName implements UserAction {

        public int key() {
            return 3;
        }

        public void execute(Input input, Tracker tracker) {
            String name  = input.ask("Please enter name of item: ");
            Item result = tracker.findByName(name);

            if (result != null) {
                tracker.displayItemInfo(result);
            } else {
                System.out.println("Sorry. No such item exists");
            }
        }

        public String info() {
            return String.format("%s. %s.", this.key(), "Find item by name");
        }
    }

    private class EditItembyID implements UserAction {

        public int key() {
            return 4;
        }

        public void execute(Input input, Tracker tracker) {
            String editID = input.ask("Please enter ID: ");
            tracker.editItemByID(editID);

        }

        public String info() {
                return String.format("%s. %s.", this.key(), "Edit item by ID");
        }
    }

    private static class DeleteItem implements UserAction {

        public int key() {
            return 5;
        }

        public void execute(Input input, Tracker tracker) {
            String id = input.ask("PLease enter ID of the item to be deleted: ");
            tracker.deleteItem(id);
        }

        public String info() {
            return String.format("%s. %s.", this.key(), "Delete item by ID");
        }
    }
}
