import java.util.ArrayList;

class Favalier extends Piece {
    public Favalier() {
        super('B', new Position());
    }

    public Favalier(char couleur, Position position) {
        super(couleur, position);
    }

    public String getType() {
        return "favalier";
    }

    public ArrayList<Position> getDeplacementPossible(Plateau pl) {
        ArrayList<Position> liste = new ArrayList<Position>();
        int positionDepartX = this.getPosition().getX();
        int positionDepartY = this.getPosition().getY();

        // Vers le haut-gauche
        int indiceX = positionDepartX - 1;
        int indiceY = positionDepartY + 1;
        while (indiceX >= 0 && indiceY < 8) {
            Piece pi = pl.getCase(indiceX, indiceY);
            if (pi == null)
                liste.add(new Position(indiceX, indiceY));
            else {
                if (pi.getCouleur() != this.getCouleur())
                    liste.add(new Position(indiceX, indiceY));
                break;
            }
            indiceX = indiceX - 1;
            indiceY = indiceY + 1;
        }
        // Vers le bas-gauche
        indiceX = positionDepartX - 1;
        indiceY = positionDepartY - 1;
        while (indiceX >= 0 && indiceY >= 0) {
            Piece pi = pl.getCase(indiceX, indiceY);
            if (pi == null)
                liste.add(new Position(indiceX, indiceY));
            else {
                if (pi.getCouleur() != this.getCouleur())
                    liste.add(new Position(indiceX, indiceY));
                break;
            }
            indiceX = indiceX - 1;
            indiceY = indiceY - 1;
        }
        // Vers le haut-droite
        indiceX = positionDepartX + 1;
        indiceY = positionDepartY + 1;
        while (indiceX < 8 && indiceY < 8) {
            Piece pi = pl.getCase(indiceX, indiceY);
            if (pi == null)
                liste.add(new Position(indiceX, indiceY));
            else {
                if (pi.getCouleur() != this.getCouleur())
                    liste.add(new Position(indiceX, indiceY));
                break;
            }
            indiceX = indiceX + 1;
            indiceY = indiceY + 1;
        }
        // Vers le bas-droite
        indiceX = positionDepartX + 1;
        indiceY = positionDepartY - 1;
        while (indiceX < 8 && indiceY >= 0) {
            Piece pi = pl.getCase(indiceX, indiceY);
            if (pi == null)
                liste.add(new Position(indiceX, indiceY));
            else {
                if (pi.getCouleur() != this.getCouleur())
                    liste.add(new Position(indiceX, indiceY));
                break;
            }
            indiceX = indiceX + 1;
            indiceY = indiceY - 1;
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
