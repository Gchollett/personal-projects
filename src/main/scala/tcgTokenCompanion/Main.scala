package tcgTokenCompanion

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.layout._
import scalafx.scene.input.MouseEvent
import scalafx.scene.image.Image
import scalafx.scene.control.ComboBox
import javafx.animation.AnimationTimer
import scala.util.control.Breaks._

object Main extends JFXApp {
    val field = BattleField()
    val dataBase = BattleField()
    dataBase.add(Token("Angel", List("Angel"), 4, 4, "w", new Image("https://c1.scryfall.com/file/scryfall-cards/large/front/3/2/323dd323-2ca2-4c85-9ef6-34341cd40d96.jpg?1641306228")))
    var widthOfStage = 0
    stage = new JFXApp.PrimaryStage {
        title = "MTG Token Companion"
        scene = new Scene(600, 700) {
                val vbox = new VBox
                var grid = createBoardState(field)
                val list = new ComboBox(createList())
                vbox.children = List(list,grid)
                list.onAction = () => {
                    for(x <- dataBase.battleField()){
                        if(x.name == list.value.value){
                            field.add(x)
                            grid = createBoardState(field)
                            vbox.children = List(list,grid)
                            content = vbox
                        }
                    }
                }
                content = vbox
                widthOfStage = width.value.toInt
        }
    }

    def createBoardState(bf:BattleField):GridPane = {
        var xGrid = 0
        var yGrid = 0
        val grid = new GridPane
        for(x <- bf.battleField){
            x.image.setFitWidth(Token.WIDTH)
            x.image.preserveRatio() = true
            x.image.onMouseClicked = (e:MouseEvent) => {
                if(e.getButton().toString == "PRIMARY"){
                    x.tap
                    tapCard(x)
                    println("tapped")
                } else bf.remove(x)
            }
            grid.add(x.image, xGrid, yGrid)
            if((xGrid+1) * Token.WIDTH < widthOfStage) xGrid += 1
            else {
                yGrid += 1
                xGrid = 0
            }
        }
        grid
    }

    def tapCard(tkn:Token) = if(tkn.tapState) tkn.image.setRotate(90) else tkn.image.setRotate(0)

    def createList() = List("Angel","Dog","Shrine")
}
