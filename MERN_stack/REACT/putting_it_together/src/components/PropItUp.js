import React, { Component } from 'react'

class PropItUp extends Component {
    constructor(props){
        super(props);
        this.state = {age: this.props.age}
        this.eventHandler = this.eventHandler.bind(this);
    }
    eventHandler(){
        this.setState(prevAge => {
            return {age: prevAge.age + 1} ;
        })
    }
    render() {
        return (
            <div>
                <div>
                    <h1>{this.props.firstName}, {this.props.lastName}</h1>
                    <p>Age: {this.state.age}</p>
                    <p>Hair Color: {this.props.hairColor}</p>
                    <button onClick={this.eventHandler}>Birthday Button for {this.props.firstName} {this.props.lastName}</button>
                </div>
            </div>
        )
    }
}
export default PropItUp;