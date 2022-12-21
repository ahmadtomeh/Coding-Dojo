const Joke = require("../models/jokes.model");

module.exports.findAllJokes = (req, res) => {
  Joke.find()
    .then(allDaJokes => res.json(allDaJokes))
    .catch(err => res.json({ message: "Something went wrong", error: err }));
};

module.exports.findOneSingleJoke = (req, res) => {
  if (req.params.id!='random'){
	Joke.findOne({ _id: req.params.id })
		.then(oneSingleJokes => res.json({oneSingleJokes}))
		.catch(err => res.json({ message: "Something went wrong", error: err }));
}
else{
 
  Joke.count(function(err, count){
    var random = Math.floor(Math.random() * count)
    Joke.findOne().skip(random)
    .then(oneSingleJokes => res.json({oneSingleJokes}))
    .catch(err => res.json({ message: "Something went wrong", error: err }))})}}

module.exports.createNewJoke = (req, res) => {
  Joke.create(req.body)
    .then(newlyCreatedJoke => res.json(newlyCreatedJoke))
    .catch(err => res.json({ message: "Something went wrong", error: err }));
};

module.exports.updateExistingJoke = (req, res) => {
  Joke.findOneAndUpdate({ _id: req.params.id }, req.body, { new: true })
    .then(updatedJoke => res.json(updatedJoke))
    .catch(err => res.json({ message: "Something went wrong", error: err }));
};

module.exports.deleteAnExistingJoke = (req, res) => {
  Joke.deleteOne({ _id: req.params.id })
    .then(result => res.json({ result: result }))
    .catch(err => res.json({ message: "Something went wrong", error: err }));
};
