public class NBody {
    public static double readRadius(String path){
        In in = new In(path);
        int number = in.readInt();
        return in.readDouble();
    }
    public static Planet[] readPlanets(String path){
        In in = new In(path);
        int number = in.readInt();
        double radius = in.readDouble();
        Planet[] ans = new Planet[number];
        for(int i = 0; i < number; i++){
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass  = in.readDouble();
            String img   = in.readString();
            ans[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, img);
        }
        return ans;
    }
    public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String path = args[2];
        double radius = readRadius(path);
        Planet[] planets = readPlanets(path);
        
        double time = 0;
        while(time < T){
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            for(int i = 0; i < planets.length; i++){
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for(int i = 0; i < planets.length; i++){
                planets[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.enableDoubleBuffering();
            StdDraw.setScale(-radius, radius);
            String backgroundImg = "images/starfield.jpg";
            StdDraw.clear();
            StdDraw.picture(0, 0, backgroundImg, radius * 2, radius * 2);
            for (Planet p : planets) {
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            time += dt;
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
}
    }
}
