package tcgTokenCompanion

import scalafx.scene.image.ImageView
import scalafx.scene.image.Image
import scalafx.scene.input.MouseEvent

class Token(val name:String, var types:List[String], var power:Char, var touphness:Char, var colors:String, val image:ImageView) {
    var number = 0
    var tapState = false
    def add():Unit = this.number += 1
    def remove():Unit = this.number -= 1
    def tap():Unit = this.tapState == !tapState
}
object Token{
    def apply(name:String, types:List[String], power:Char, touphness:Char, colors:String, image:ImageView) = new Token(name,types,power,touphness,colors,image)
    def apply(name:String, types:List[String], power:Char, touphness:Char, colors:String, image:Image) = {
        val imageView = new ImageView
        imageView.setImage(image)
        new Token(name,types,power,touphness,colors,imageView)
    }
    val WIDTH = 95
}
