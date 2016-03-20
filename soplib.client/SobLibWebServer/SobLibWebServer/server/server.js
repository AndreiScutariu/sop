var express = require("express"),
    stylus = require("stylus"),
    logger = require("morgan"),
    bodyParser = require("body-parser");

var app = express();

//configs, move to application start step file
app.set("views", __dirname + "/views");
app.set("view engine", "jade");
app.use(logger("dev"));
app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

//server routing
app.use(express.static(__dirname + "/../public"));
app.get("/partials/:partialPath", function (req, res) {
    res.render("partials/" + req.params.partialPath);
});
app.get("*", function (req, res) {
    res.render("index", {
        hello: 'hello'
    });
});

//start app
var port = 8089;
app.listen(port);
console.log("start listening on port " + port + "...");