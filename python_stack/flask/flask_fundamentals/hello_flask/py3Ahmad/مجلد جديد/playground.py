from flask import Flask, render_template

app = Flask(__name__)

@app.route('/')
def hello_world():
    return render_template('playground.html', phrase="hello", times=8)

@app.route('/index')
def hello_world2():
    return render_template('index.html', phrase="hello", times=3)

if __name__ == "__main__":
    app.run(debug=True)