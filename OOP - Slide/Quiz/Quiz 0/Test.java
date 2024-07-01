public class Test {
    public void testParticles() {
        // Create two particles
        Particle p1 = new Particle(3, 5);
        Particle p2 = new Particle(2, 6);

        // Make them move
        p1.move();
        p2.move();

        // Check whether two particles collide
        if (p1.collidesWith(p2)) {
            System.out.println("Particles collided!");
        } else {
            System.out.println("Particles did not collide.");
        }
    }
}