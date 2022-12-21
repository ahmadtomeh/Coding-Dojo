const mongoose = require("mongoose");

const JokeSchema = new mongoose.Schema({
	setup:{ 
		type:String ,
		required:[true,"setup is required"],
		minlength:[10,"setup must be at lest 10"]} ,
	punchline:{ 
        type:String ,
        required:[true,"punchine is required"],
        minlength:[3,"punchine must be at lest 3"]}
});


const Joke = mongoose.model("joke", JokeSchema);

module.exports = Joke;