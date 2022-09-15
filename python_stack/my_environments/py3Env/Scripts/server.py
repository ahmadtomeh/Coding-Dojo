from flask import Flask

app = Flask(__name__)


@app.route("/")
def index():
    return "Hello World!"

@app.route("/dojo")
def index1():
    return "Dojo!"

@app.route('/say/<name>')
def hello(name):
    print(name)
    return "Hi, " + name +"!"

@app.route('/<num>/<name>')
def hello1(num,name):
    print(name)
    return f"{int(num)*name}"

if __name__ == "__main__":
    app.run(debug=True)