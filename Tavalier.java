import java.util.ArrayList;

class tavalier extends Piece {
    
    public tavalier(){
        super('B', new Position());
    }

    public tavalier(char couleur, Position position){
        super(couleur, position);
    }


    public String getType(){
        return new String("tavalier");
    }
    

    public ArrayList<Position> getDeplacementPossible(Plateau pl)
    {
        ArrayList<Position> liste = new ArrayList<Position>();
        int positionDepartX = this.getPosition().getX();
        int positionDepartY = this.getPosition().getY();

        // Déplacements de la tour
        // Vers le bas
        boolean obstacle = false;
        int indiceX = positionDepartX;
        int indiceY = positionDepartY - 1;
        while(!obstacle && indiceY >= 0){
            Piece pi = pl.getCase(indiceX, indiceY);
            if(pi == null)
                liste.add(new Position(indiceX, indiceY));
            else{
                obstacle = true;
                if(pi.getCouleur() != this.getCouleur())
                    liste.add(new Position(indiceX, indiceY));
            }
            indiceY = indiceY - 1;
        }
        // Vers le haut
        obstacle = false;
        indiceX = positionDepartX;
        indiceY = positionDepartY + 1;
        while(!obstacle && indiceY <= 7){
            Piece pi = pl.getCase(indiceX, indiceY);
            if(pi == null)
                liste.add(new Position(indiceX, indiceY));
            else{
                obstacle = true;
                if(pi.getCouleur() != this.getCouleur())
                    liste.add(new Position(indiceX, indiceY));
            }
            indiceY = indiceY + 1;
        }

        // Vers la gauche
        obstacle = false;
        indiceX = positionDepartX - 1;
        indiceY = positionDepartY;
        while(!obstacle && indiceX >= 0){
            Piece pi = pl.getCase(indiceX, indiceY);
            if(pi == null)
                liste.add(new Position(indiceX, indiceY));
            else{
                obstacle = true;
                if(pi.getCouleur() != this.getCouleur())
                    liste.add(new Position(indiceX, indiceY));
            }
            indiceX = indiceX - 1;
        }
        // Vers la droite
        obstacle = false;
        indiceX = positionDepartX + 1;
        indiceY = positionDepartY;
        while(!obstacle && indiceX <= 7){
            Piece pi = pl.getCase(indiceX, indiceY);
            if(pi == null)
                liste.add(new Position(indiceX, indiceY));
            else{
                obstacle = true;
                if(pi.getCouleur() != this.getCouleur())
                    liste.add(new Position(indiceX, indiceY));
            }
            indiceX = indiceX + 1;
        }

        // Déplacements du cavalier
        int[] dx = { -2, -1, 1, 2, -2, -1, 1, 2 };
        int[] dy = { -1, -2, -2, -1, 1, 2, 2, 1 };
        
        for (int i = 0; i < 8; i++) {
            int newX = positionDepartX + dx[i];
            int newY = positionDepartY + dy[i];
            if (newX >= 0 && newX < 8 && newY >= 0 && newY < 8) {
                Piece pi = pl.getCase(newX, newY);
                if (pi == null || pi.getCouleur() != this.getCouleur()) {
                    liste.add(new Position(newX, newY));
                }
            }
        }
        
        return liste;
    }
}
