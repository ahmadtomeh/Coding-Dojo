function swb(str){
    var temp = "";
    for (i=0; i<str.length; i++)
    if (str[i] != " " && str[i] != "." && str[i] != ","){
        temp += str[i];
    }
    console.log(temp);
} 

swb("hello world . ahmad ,tomeh frgdfgdf .....,,,")