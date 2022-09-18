from flask import Flask, render_template

app = Flask(__name__)

@app.route('/')
def hello_world():
    return render_template('index.html', phrase="hello", times=5)

@app.route('/dojo')
def dojo():
    return 'Dojo'

@app.route('/say/<name>')
def say(name):
    return f"hello {name}"

@app.route('/say/<int:num>/<name>/<string:color>')
def repeat(num, name, color):
    return f"<h1 style='color:{color};'> {name}" * num

if __name__ == "__main__":
    app.run(debug=True)