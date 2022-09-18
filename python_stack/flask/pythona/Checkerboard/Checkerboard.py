from flask import Flask, render_template

app = Flask(__name__)   

@app.route('/<row>/<column>')
def boxes(row,column):
    return render_template("Checkerboard.html",row1=int(row),column1=int(column))

@app.route('/<row>/<column>/<co1>/<co2>')
def boxes0(row, column, co1, co2):
    return render_template("Checkerboard.html",row1=int(row),column1=int(column), col1 = co1, col2 = co2)

@app.route('/')
def boxes1(row = 8, column = 8):
    return render_template("Checkerboard.html",row1=int(row),column1=int(column))

@app.route('/4')
def boxes2(row = 8, column = 4):
    return render_template("Checkerboard.html",row1=int(row),column1=int(column))


if __name__=="__main__":
    
    app.run(debug=True)    