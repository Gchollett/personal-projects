package tcgTokenCompanion

class BattleField(){
    private var battleField:List[Token] = Nil
    
    def add(tkn:Token):Unit = this.battleField :+= tkn
    def remove(tkn:Token):Unit = {
        var temp:List[Token] = Nil
        if(this.battleField.contains(tkn)){
            for(card <- this.battleField){
                if(card != tkn) temp :+= card
            }
        }
        this.battleField = temp
    }
}

object BattleField {
    def apply() = new BattleField()
    
}