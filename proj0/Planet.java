public class Planet {
	/**
	 * 	double xxPos: Its current x position
	 *	double yyPos: Its current y position
	 *	double xxVel: Its current velocity in the x direction
	 *	double yyVel: Its current velocity in the y direction
	 *	double mass: Its mass
	 *	String imgFileName: The name of the file that corresponds to the image that depicts the planet 	
	 *  public static final double G: Universal gravitational constant
	 */
	double xxPos;
	double yyPos;
	double xxVel;
	double yyVel;
	double mass;
	String imgFileName;

	public Planet(double xP, double yP, double xV, double yV, double m, String img) {
		this.xxPos = xP;
		this.yyPos = yP;
		this.xxVel = xV;
		this.yyVel = yV;
		this.mass = m;
		this.imgFileName = img;
	}

	public Planet(Planet p) {
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}
    public double calcDistance(Planet p) {
        double distanceX = p.xxPos - xxPos;
        double distanceY = p.yyPos - yyPos;
        return Math.sqrt(distanceX * distanceX + distanceY * distanceY);
    }
    public double calcForceExertedBy(Planet p) {
        double distance = this.calcDistance(p);
        return (6.67e-11 * this.mass * p.mass) / (distance * distance);
    }
    public double calcForceExertedByX(Planet p) {
        double ForceExertedBy = calcForceExertedBy(p);
        return ForceExertedBy  * (p.xxPos-this.xxPos) / (calcDistance(p));
    }
    public double calcForceExertedByY(Planet p) {
        double ForceExertedBy = calcForceExertedBy(p);
        return ForceExertedBy * (p.yyPos-this.yyPos) / (calcDistance(p));
    }
    public double calcNetForceExertedByX(Planet[] p) {
        double netforcex = 0;
        for(Planet pp : p){
            if(pp.equals(this) == false){
                netforcex += calcForceExertedByX(pp);
            }
        }
        return netforcex;
    }
    public double calcNetForceExertedByY(Planet[] p) {
        double netforcey = 0;
        for(Planet pp : p){
            if(pp.equals(this) == false){
                netforcey += calcForceExertedByY(pp);
            }
        }
        return netforcey;
    }
    public void update(double dt, double fX, double fY){
        this.xxVel = this.xxVel + dt * fX / this.mass;
        this.yyVel = this.yyVel + dt * fY / this.mass;
        this.xxPos += dt * this.xxVel;
        this.yyPos += dt * this.yyVel;
    }
    public void draw(){
        String img = "images/" + this.imgFileName;
        StdDraw.picture(this.xxPos, this.yyPos, img);
    }
}