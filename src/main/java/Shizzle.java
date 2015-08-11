import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;



public class Shizzle {
    public static void main(String[] args) {

        String layout = "templates/layout.vtl";

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/home.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/answer", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/answer.vtl");

            String sentence = request.queryParams("sentence");
            String getShizzle = getShizzle(sentence);

            model.put("getShizzle", getShizzle);
            model.put("sentence", request.queryParams("sentence"));


            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());






    }

        public static String getShizzle(String userWord) {
            String shizzledWord = "";

        for (Integer i = 0; i < userWord.length(); i++) {
            if (i == 0) {
                shizzledWord += userWord.charAt(i);
            } else if ( userWord.charAt(i - 1) == ' ') {
                shizzledWord += userWord.charAt(i);

            } else if (userWord.charAt(i) == 's') {
                shizzledWord += "z";
            } else {
                shizzledWord += userWord.charAt(i);
            }

        }
        return shizzledWord;
    }
}
