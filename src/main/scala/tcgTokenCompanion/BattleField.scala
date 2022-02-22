package tcgTokenCompanion

class BattleField(){
    private var bF:List[Token] = Nil

    def add(tkn:Token):Unit = {
        val location = bF.indexOf(tkn)
        if( location != -1){
            bF(location).add()
        }
        else this.bF :+= tkn
    }
    def remove(tkn:Token):Unit = {
        val location = bF.indexOf(tkn)
        var temp:List[Token] = Nil
        if(location != -1){
            if(bF(location).number > 1){
                bF(location).remove()
            }
            else {
                for(card <- this.bF){
                    if(card != tkn) temp :+= card
                }
            }
        }
        this.bF = temp
    }

    def tapAll(){
        for(x <- bF){
            x.tapState = true
        }
    }

    def untapAll(){
        for(x <- bF){
            x.tapState = false
        }
    }

    //getters
    def battleField():List[Token] = bF
}

object BattleField {
    def apply() = new BattleField()
}