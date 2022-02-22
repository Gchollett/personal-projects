package tcgTokenCompanion

class BattleField(){
    private var battleField:List[Token] = Nil

    def add(tkn:Token):Unit = {
        val location = battleField.indexOf(tkn)
        if( location != -1){
            battleField(location).add()
        }
        else this.battleField :+= tkn
    }
    def remove(tkn:Token):Unit = {
        val location = battleField.indexOf(tkn)
        var temp:List[Token] = Nil
        if(location != -1){
            if(battleField(location).number > 1){
                battleField(location).remove()
            }
            else {
                for(card <- this.battleField){
                    if(card != tkn) temp :+= card
                }
            }
        }
        this.battleField = temp
    }
}

object BattleField {
    def apply() = new BattleField()
}