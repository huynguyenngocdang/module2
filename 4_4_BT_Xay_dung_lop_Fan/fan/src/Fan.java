public class Fan {
    String id;
    String color;
    int radius;
    int speed;
    boolean status;
    public Fan(String id, String color, int radius, int speed, boolean status) {
        this.id = id;
        this.color = color;
        this.radius = radius;
        this.speed = speed;
        this.status = status;
    }

    public void slow() {
        this.speed = 1;
        this.status = true;
    }

    public void medium() {
        this.speed = 2;
        this.status = true;
    }

    public void fast() {
        this.speed = 3;
        this.status = true;
    }

    public int getSpeed() {
        return this.speed;
    }

    public String getFanInfo() {
        String fanInfo = "";
        fanInfo += "Id: " + this.id + "\n";
        fanInfo += "Speed: " + this.speed + "\n";
        fanInfo += "Color: " + this.color + "\n";
        fanInfo += "Radius: " + this.radius + "\n";
        if (this.status) {
            fanInfo += "Fan is on";
        } else {
            fanInfo += "Fan is off";
        }
        return fanInfo;
    }

    @Override
    public String toString() {
        String fanInfo = "";
        fanInfo += "[Id: " + this.id + "\n";
        fanInfo += "Speed: " + this.speed + "\n";
        fanInfo += "Color: " + this.color + "\n";
        fanInfo += "Radius: " + this.radius + "\n";
        if (this.status) {
            fanInfo += "Fan is on] \n";
        } else {
            fanInfo += "Fan is off] \n";
        }
        return fanInfo;
    }

}
