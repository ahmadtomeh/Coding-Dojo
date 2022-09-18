from flask import Flask, render_template

app = Flask(__name__)   

@app.route0('/play/<int:num>/<color>')
def boxes(num, color):
    return render_template("playGround.html", num1 = num , c = color)

@app.route('/play/<int:num>')
def boxes1(num, color= "blue"):
    return render_template("playGround.html", num1 = num , c = color)

@app.route('/play')
def boxes2(num = 3, color= "blue"):
    return render_template("playGround.html", num1 = num , c = color)


if __name__=="__main__":
    
    app.run(debug=True)    