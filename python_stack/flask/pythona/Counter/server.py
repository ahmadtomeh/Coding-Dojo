from flask import Flask, render_template, redirect, session

app = Flask(__name__)
app.secret_key = 'hhhhh'

@app.route('/')
def index():
    if 'number' in session:
        session['number']+=1
    else:
        session['number']=1
        
    return render_template("index.html", num=session['number'])
@app.route('/destroy_session')
def delete():
    session.pop('number')	
    return redirect ('/')


if __name__ == "__main__":
    app.run(debug=True)

