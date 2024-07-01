class Rectangle {
    // Attributes
    private int width;
    private int height;

    // Constructor
    public Rectangle(int width, int height) {
        if (width < 0) {
            System.out.println("Warning: input width is negative!");
            this.width = 1;
        } else {
            this.width = width;
        }

        if (height < 0) {
            System.out.println("Warning: input height is negative!");
            this.height = 1;
        } else {
            this.height = height;
        }
    }

    // Getter for width
    public int getWidth() {
        return width;
    }

    // Getter for height
    public int getHeight() {
        return height;
    }

    // Method to visualize rectangle
    public void visualize() {
        for (int i = 0; i < height; i++) { // Loop outside
            for (int j = 0; j < width; j++) {
                System.out.print("* "); // Do this loop then go outside
            }
            System.out.println();
        }
    }
}
