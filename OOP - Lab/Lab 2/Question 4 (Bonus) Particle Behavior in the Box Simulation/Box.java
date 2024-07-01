import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Box {
    private static Box instance;
    private int width;
    private int height;
    private List<Particle> particles;

    private Box(int width, int height) {
        this.width = width;
        this.height = height;
        particles = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            particles.add(new Particle(random.nextInt(width), random.nextInt(height)));
        }
    }

    public static Box getInstance() {
        if (instance == null) {
            instance = new Box(10, 10); // Default size of the box
        }
        return instance;
    }

    public void simulate(int steps) {
        for (int i = 0; i < steps; i++) {
            moveParticles();
            checkCollisions();
            System.out.println("Step " + (i + 1) + ": Number of particles = " + particles.size());
            visualizeBox();
        }
    }

    private void moveParticles() {
        for (Particle particle : particles) {
            particle.moveRandomly();
        }
    }

    private void checkCollisions() {
        List<Particle> newParticles = new ArrayList<>();
        for (Particle particle : particles) {
            for (Particle other : particles) {
                if (particle != other && particle.getX() == other.getX() && particle.getY() == other.getY()) {
                    newParticles.add(new Particle(particle.getX(), particle.getY()));
                }
            }
        }
        particles.addAll(newParticles);
    }

    private void visualizeBox() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                boolean isParticle = false;
                for (Particle particle : particles) {
                    if (particle.getX() == j && particle.getY() == i) {
                        isParticle = true;
                        break;
                    }
                }
                if (isParticle) {
                    System.out.print("* ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
        System.out.println("-------------------------");
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
