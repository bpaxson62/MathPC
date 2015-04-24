package launch;

/**
 * Created by brian on 3/14/2015.
 */
public final class Configurations  {

    //Window Sizes
    public static final int MAIN_SCREEN_WIDTH=1400;
    public static final int MAIN_SCREEN_HEIGHT=720;
    public static final int SCORE_SCREEN_WIDTH=0;
    public static final int SCORE_SCREEN_HEIGHT=0;
    public static final int WINDOW_BOARDER=3;
    public static final int TITLE_BAR_HEIGHT=0;

    //CSS
    public final static  String buttonStyle = " -fx-background-color:\n" +
            "    linear-gradient(#ffd65b, #e68400),\n" +
            "    linear-gradient(#ffef84, #f2ba44),\n" +
            "    linear-gradient(#f9f2d6 0%, #f4e5bc 20%, #e6c75d 80%, #e2c045 100%),\n" +
            "    linear-gradient(#f6ebbe, #e6c34d)\n" +
            "    linear-gradient(#ffea6a, #efaa22),\n" +
            "    linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));\n" +
            "    -fx-background-radius: 30;\n" +
            "    -fx-background-insets: 0,1,2,3,0;\n" +
            "    -fx-text-fill: #654b00;\n" +
            "    -fx-font-weight: bold;\n" +
            "    -fx-padding: 10 20 10 20;" +
            "    -fx-font-size: 30pt;";

    public final static String backGroundStyle = " -fx-background-color:\n" +
            "    linear-gradient(#ffd65b, #e68400),\n" +
            "    linear-gradient(#ffef84, #f2ba44),\n" +
            "    linear-gradient(#f9f2d6 0%, #f4e5bc 20%, #e6c75d 80%, #e2c045 100%),\n" +
            "    linear-gradient(#f6ebbe, #e6c34d)\n" +
            "    linear-gradient(#ffea6a, #efaa22),\n" +
            "    linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));\n";
    //Difficulty settings
    public static final int LIFE_POINTS=0;
    public static final int BUBBLE_STARTING_RADIUS=0;

    public static final String circleStyle = "-fx-fill: \n" +
            "        linear-gradient(#ffd65b, #e68400),\n" +
            "        linear-gradient(#ffef84, #f2ba44),\n" +
            "        linear-gradient(#ffea6a, #efaa22),\n" +
            "        linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),\n" +
            "        linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));\n" +
            "    -fx-background-radius: 30;\n" +
            "    -fx-background-insets: 0,1,2,3,0;\n" +
            "    -fx-text-fill: #654b00;\n" +
            "    -fx-font-weight: bold;\n" +
            "    -fx-font-size: 14px;\n" +
            "    -fx-padding: 10 20 10 20;";

    //Difficulty Names

    public final static String shapeStyle ="-fx-fill:\n" +
            "        linear-gradient(#f0ff35, #a9ff00),\n" +
            "        radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);\n" +
            "    -fx-background-radius: 6, 5;\n" +
            "    -fx-background-insets: 0, 1;\n" +
            "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );\n" +
            "    -fx-text-fill: #395306;";

    public final static String wrongAnswer ="   -fx-fill: linear-gradient(#ff5400, #be1d00);\n" +
            "    -fx-background-radius: 30;\n" +
            "    -fx-background-insets: 0;\n" +
            "    -fx-text-fill: white;";

    public final static String answers =" -fx-fill: \n" +
//            "        rgba(0,0,0,0.08),\n" +
            "        linear-gradient(#5a61af, #51536d),\n" +
            "        linear-gradient(#e4fbff 0%,#cee6fb 10%, #a5d3fb 50%, #88c6fb 51%, #d5faff 100%);\n" +
            "    -fx-background-insets: 0 0 -1 0,0,1;\n" +
            "    -fx-background-radius: 5,5,4;\n" +
            "    -fx-padding: 3 30 3 30;\n" +
            "    -fx-text-fill: #242d35;\n" +
            "    -fx-font-size: 14px;";
}
