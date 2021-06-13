
package API;

public final class Board {

    Piece[][] board;

    public Board() throws FILException {
        this(6,7);

    }
    
    public Board(int size1, int size2) throws FILException {
    	board = new Piece[size1][size2];
        restart();
    }

    public void restart() throws FILException {
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                board[y][x] = new Piece(".");
            }
        }
    }

    public final String toString() {
        StringBuilder txt = new StringBuilder();
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                txt.append(board[y][x].getTxt() + " ");
            }
            txt.append("\n");
        }
        return txt.toString();
    }
    
    public final void play(Piece p, int x) throws FILException {
    	int y = board.length - 1;
    	
        if (x < 0 || x >= board[0].length) {
            throw new FILException("Sítio errado");
        }
        
        if (!board[y][x].isEmpty()) {
        	int val = 1;
            while (val <= board.length ) {
            	if (y - val < 0) {
            		throw new FILException("Fila Cheia");
            	}else {
	            	if (!board[y - val][x].isEmpty()) {
	            		val++;
	            	}else {
	            		board[y - val][x] = new Piece(p);
	            		break;
	            	}
            	}
            	
            }
        }else {
        	board[y][x] = new Piece(p);
        }
        
    }

    public final boolean isFull() {
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                if (board[y][x].isEmpty()) return false;
            }
        }
        return true;
    }

    public final boolean isWinner(Piece p, int check) {
        int count = 0;

        //linhas -->
        for (int y = 0; y < board.length; y++) {
            count = 0;
            for (int x = 0; x < board[y].length; x++) {
                if (board[y][x].equals(p)) {
                    count++;
                    if (count == check) return true;
                } else {
                	count = 0;
                }
            }
        }

        //colunas \/
        for (int x = 0; x < board[0].length; x++) {
        	count = 0;
            for (int y = 0; y < board.length; y++) {
                if (board[y][x].equals(p)) {
                    count++;
                    if (count == check) return true;
                } else {
                	count = 0;
                }
            }
        }

        //diagonal \   \/
        for (int val = -board[0].length; val < board[0].length; val++) {
	        count = 0;
	        for (int y = 0; y < board.length; y++) {
	            for (int x = 0; x < board[y].length; x++) {
	            	if (x == y + val) {
	            		if (board[y][x].equals(p)) {
		                    count++;
		                    if (count == check) return true;
		                } else {
		                	count = 0;
		                }
	            	}
	            }
	        }
        }

        //diagonal /   \/
        for (int val = -board.length; val < board.length; val++) {
	        count = 0;
	        for (int y = 0; y < board.length; y++) {
	            for (int x = 0; x < board[y].length; x++) {
	            	if ((board.length - 1) - x - 1 == y + val) {
	            		if (board[y][x].equals(p)) {
		                    count++;
		                    if (count == check) return true;
	            		} else {
		                	count = 0;
		                }
	            	}
	            }
	        }
        }
        
        return count == check;
    }
    
    public final boolean mysteryWinnercheck(Piece p, int check) {
        int count = 0;

        //linhas 
        for (int y = 0; y < board.length; y++) {
            count = 0;
            for (int x = 0; x < board[y].length; x++) {
                if (board[y][x].equals(p)) {
                    count++;
                }
            }
            if (count == check) return true;
        }

        //colunas
        for (int x = 0; x < board[0].length; x++) {
        	count = 0;
            for (int y = 0; y < board.length; y++) {
                if (board[y][x].equals(p)) {
                    count++;
                }
            }
            if (count == check) {
                return true;
            }
        }

        //diagonal principal
        for (int val = -board[0].length; val < board[0].length; val++) {
	        count = 0;
	        for (int y = 0; y < board.length; y++) {
	            for (int x = 0; x < board[y].length; x++) {
	            	if (x == y + val) {
	            		if (board[y][x].equals(p)) {
		                    count++;
		                }
	            	}
	            }
	            if (count == check) {
	                return true;
	            }
	        }
        }

        //diagonal principal
        for (int val = -board.length; val < board.length; val++) {
	        count = 0;
	        for (int y = 0; y < board.length; y++) {
	            for (int x = 0; x < board[y].length; x++) {
	            	if ((board.length - 1) - x - 1 == y + val) {
	            		if (board[y][x].equals(p)) {
		                    count++;
	            		}
	            	}
	            }
	            if (count == check) {
	                return true;
	            }
	        }
        }
        
        return count == check;
    }
    
    public int chekagembotnormal(Piece p, Piece p1, int check, int temp) {
    	int count = 0;
    	
    	//linhas -->
        for (int y = 0; y < board.length; y++) {
            count = 0;
            for (int x = 0; x < board[y].length; x++) {
                if (board[y][x].equals(p)) {
                    count++;
                    if (count == check) {
                    	try {
	                    	if (board[y][x+1].equals(p1) || !board[y][x+1].equals(p) && !board[y][x+1].equals(p1)) {
	                    		continue;
	                    	}else {
	                    		if (x+1 != temp) return x+1;
	                    	}
                    	}catch (ArrayIndexOutOfBoundsException e){ continue; }
                    }
                } else {
                	count = 0;
                }
            }
        }
        
        //linhas <--
        for (int y = board.length-1; y >= 0 ; y--) {
            count = 0;
            for (int x = board[y].length-1; x >= 0 ; x--) {
                if (board[y][x].equals(p)) {
                    count++;
                    if (count == check) {
                    	try {
	                    	if (board[y][x-1].equals(p1) || !board[y][x-1].equals(p) && !board[y][x-1].equals(p1)) {
	                    		continue;
	                    	}else {
	                    		if (x-1 != temp) return x-1;
	                    	}
                    	}catch (ArrayIndexOutOfBoundsException e){ continue; }
                    }
                } else {
                	count = 0;
                }
            }
        }

        //colunas \/
        for (int x = 0; x < board[0].length; x++) {
        	count = 0;
            for (int y = 0; y < board.length; y++) {
                if (board[y][x].equals(p)) {
                    count++;
                    if (count == check) if (x != temp) return x;
                } else {
                	count = 0;
                }
            }
        }
        
        //diagonal \   \/
        for (int val = -board[0].length; val < board[0].length; val++) {
	        count = 0;
	        for (int y = 0; y < board.length; y++) {
	            for (int x = 0; x < board[y].length; x++) {
	            	if (x == y + val) {
	            		if (board[y][x].equals(p)) {
		                    count++;
		                    if (count == check) {
		                    	try {
			                    	if (!board[y+1][x+1].equals(p)) {
			                    		if (x+1 != temp) return x+1;
			                    	}
		                    	} catch (ArrayIndexOutOfBoundsException e) {
		                    		try {
			                    		if (!board[y-check][x-check].equals(p)) {
			                    			if (x-check != temp) return x-check;
				                    	}
		                    		} catch (ArrayIndexOutOfBoundsException e1) { continue; }
		                    	}
		                    }
		                } else {
		                	count = 0;
		                }
	            	}
	            }
	        }
        }

        //diagonal /   \/
        for (int val = -board.length; val < board.length; val++) {
	        count = 0;
	        for (int y = 0; y < board.length; y++) {
	            for (int x = 0; x < board[y].length; x++) {
	            	if ((board.length - 1) - x - 1 == y + val) {
	            		if (board[y][x].equals(p)) {
		                    count++;
		                    if (count == check) {
		                    	try {
			                    	if (!board[y+1][x-1].equals(p)) {
			                    		if (x-1 != temp) return x-1;
			                    	}
		                    	} catch (ArrayIndexOutOfBoundsException e) {
		                    		try {
			                    		if (!board[y-check][x+check].equals(p)) {
			                    			if (x+check != temp) return x+check;
				                    	}
		                    		} catch (ArrayIndexOutOfBoundsException e1) { continue; }
		                    	}
		                    }
	            		} else {
		                	count = 0;
		                }
	            	}
	            }
	        }
        }
        
        return -1;
    	
    }
    
    public int chekagembotmedio(Piece p, Piece p1, int check, int temp) {
    	int count = 0;
    	
    	//linhas -->
        for (int y = 0; y < board.length; y++) {
            count = 0;
            for (int x = 0; x < board[y].length; x++) {
                if (board[y][x].equals(p1)) {
                    count++;
                    if (count == check) {
                    	try {
	                    	if (board[y][x+1].equals(p) || !board[y][x+1].equals(p) && !board[y][x+1].equals(p1)) {
	                    		continue;
	                    	}else {
	                    		if (x+1 != temp) return x+1;
	                    	}
                    	}catch (ArrayIndexOutOfBoundsException e){ continue; }
                    }
                } else {
                	count = 0;
                }
            }
        }
        
        //linhas <--
        for (int y = board.length-1; y >= 0 ; y--) {
            count = 0;
            for (int x = board[y].length-1; x >= 0 ; x--) {
                if (board[y][x].equals(p1)) {
                    count++;
                    if (count == check) {
                    	try {
	                    	if (board[y][x+1].equals(p) || !board[y][x+1].equals(p) && !board[y][x+1].equals(p1)) {
	                    		continue;
	                    	}else {
	                    		if (x-1 != temp) return x-1;
	                    	}
                    	}catch (ArrayIndexOutOfBoundsException e){ continue; }
                    }
                } else {
                	count = 0;
                }
            }
        }

        //colunas \/
        for (int x = 0; x < board[0].length; x++) {
        	count = 0;
            for (int y = 0; y < board.length; y++) {
                if (board[y][x].equals(p1)) {
                    count++;
                    if (count == check) if (x != temp) return x;
                } else {
                	count = 0;
                }
            }
        }
        
      //diagonal \   \/
        for (int val = -board[0].length; val < board[0].length; val++) {
	        count = 0;
	        for (int y = 0; y < board.length; y++) {
	            for (int x = 0; x < board[y].length; x++) {
	            	if (x == y + val) {
	            		if (board[y][x].equals(p1)) {
		                    count++;
		                    if (count == check) {
		                    	try {
			                    	if (!board[y+1][x+1].equals(p1)) {
			                    		if (x+1 != temp) return x+1;
			                    	}
		                    	} catch (ArrayIndexOutOfBoundsException e) {
		                    		try {
			                    		if (!board[y-check][x-check].equals(p1)) {
			                    			if (x-check != temp) return x-check;
				                    	}
		                    		} catch (ArrayIndexOutOfBoundsException e1) { continue; }
		                    	}
		                    }
		                } else {
		                	count = 0;
		                }
	            	}
	            }
	        }
        }

        //diagonal /   \/
        for (int val = -board.length; val < board.length; val++) {
	        count = 0;
	        for (int y = 0; y < board.length; y++) {
	            for (int x = 0; x < board[y].length; x++) {
	            	if ((board.length - 1) - x - 1 == y + val) {
	            		if (board[y][x].equals(p1)) {
		                    count++;
		                    if (count == check) {
		                    	try {
			                    	if (!board[y+1][x-1].equals(p1)) {
			                    		if (x-1 != temp) return x-1;
			                    	}
		                    	} catch (ArrayIndexOutOfBoundsException e) {
		                    		try {
			                    		if (!board[y-check][x+check].equals(p1)) {
			                    			if (x+check != temp) return x+check;
				                    	}
		                    		} catch (ArrayIndexOutOfBoundsException e1) { continue; }
		                    	}
		                    }
	            		} else {
		                	count = 0;
		                }
	            	}
	            }
	        }
        }
    	
    	//linhas -->
        for (int y = 0; y < board.length; y++) {
            count = 0;
            for (int x = 0; x < board[y].length; x++) {
                if (board[y][x].equals(p)) {
                    count++;
                    //System.out.println(count);
                    if (count == check) {
                    	try {
	                    	if (board[y][x+1].equals(p1) || !board[y][x+1].equals(p) && !board[y][x+1].equals(p1)) {
	                    		continue;
	                    	}else {
	                    		if (x+1 != temp) return x+1;
	                    	}
                    	}catch (ArrayIndexOutOfBoundsException e){ continue; }
                    }
                } else {
                	count = 0;
                }
            }
        }
        
        //linhas <--
        for (int y = board.length-1; y >= 0 ; y--) {
            count = 0;
            for (int x = board[y].length-1; x >= 0 ; x--) {
                if (board[y][x].equals(p)) {
                    count++;
                    //System.out.println(count);
                    if (count == check) {
                    	try {
	                    	if (board[y][x-1].equals(p1) || !board[y][x-1].equals(p) && !board[y][x-1].equals(p1)) {
	                    		continue;
	                    	}else {
	                    		if (x-1 != temp) return x-1;
	                    	}
                    	}catch (ArrayIndexOutOfBoundsException e){ continue; }
                    }
                } else {
                	count = 0;
                }
            }
        }

        //colunas \/
        for (int x = 0; x < board[0].length; x++) {
        	count = 0;
            for (int y = 0; y < board.length; y++) {
                if (board[y][x].equals(p)) {
                    count++;
                    //System.out.println(count);
                    if (count == check) if (x != temp) return x;
                } else {
                	count = 0;
                }
            }
        }
        
        //diagonal \   \/
        for (int val = -board[0].length; val < board[0].length; val++) {
	        count = 0;
	        for (int y = 0; y < board.length; y++) {
	            for (int x = 0; x < board[y].length; x++) {
	            	if (x == y + val) {
	            		if (board[y][x].equals(p)) {
		                    count++;
		                    if (count == check) {
		                    	try {
			                    	if (!board[y+1][x+1].equals(p)) {
			                    		if (x+1 != temp) return x+1;
			                    	}
		                    	} catch (ArrayIndexOutOfBoundsException e) {
		                    		try {
			                    		if (!board[y-check][x-check].equals(p)) {
			                    			if (x-check != temp) return x-check;
				                    	}
		                    		} catch (ArrayIndexOutOfBoundsException e1) { continue; }
		                    	}
		                    }
		                } else {
		                	count = 0;
		                }
	            	}
	            }
	        }
        }

        //diagonal /   \/
        for (int val = -board.length; val < board.length; val++) {
	        count = 0;
	        for (int y = 0; y < board.length; y++) {
	            for (int x = 0; x < board[y].length; x++) {
	            	if ((board.length - 1) - x - 1 == y + val) {
	            		if (board[y][x].equals(p)) {
		                    count++;
		                    if (count == check) {
		                    	try {
			                    	if (!board[y+1][x-1].equals(p)) {
			                    		if (x-1 != temp) return x-1;
			                    	}
		                    	} catch (ArrayIndexOutOfBoundsException e) {
		                    		try {
			                    		if (!board[y-check][x+check].equals(p)) {
			                    			if (x+check != temp) return x+check;
				                    	}
		                    		} catch (ArrayIndexOutOfBoundsException e1) { continue; }
		                    	}
		                    }
	            		} else {
		                	count = 0;
		                }
	            	}
	            }
	        }
        }
        
        return -1;
    	
    }
    
    public int chekagembothard(Piece p, Piece p1, int check, int temp) {
    	int count = 0;
    	int blank = 0;
        
    	//linhas -->
        for (int y = 0; y < board.length; y++) {
            count = 0;
            for (int x = 0; x < board[y].length; x++) {
                if (board[y][x].equals(p1)) {
                    count++;
                    if (count == check) {
                    	try {
	                    	if (board[y][x+1].equals(p) || !board[y][x+1].equals(p) && !board[y][x+1].equals(p1)) {
	                    		continue;
	                    	}else {
	                    		if (x+1 != temp) return x+1;
	                    	}
                    	}catch (ArrayIndexOutOfBoundsException e){ continue; }
                    }
                } else {
                	count = 0;
                }
            }
        }
        
        //linhas <--
        for (int y = board.length-1; y >= 0 ; y--) {
            count = 0;
            for (int x = board[y].length-1; x >= 0 ; x--) {
                if (board[y][x].equals(p1)) {
                    count++;
                    if (count == check) {
                    	try {
	                    	if (board[y][x+1].equals(p) || !board[y][x+1].equals(p) && !board[y][x+1].equals(p1)) {
	                    		continue;
	                    	}else {
	                    		if (x-1 != temp) return x-1;
	                    	}
                    	}catch (ArrayIndexOutOfBoundsException e){ continue; }
                    }
                } else {
                	count = 0;
                }
            }
        }

        //colunas \/
        for (int x = 0; x < board[0].length; x++) {
        	count = 0;
            for (int y = 0; y < board.length; y++) {
                if (board[y][x].equals(p1)) {
                    count++;
                    if (count == check) if (x != temp) return x;
                } else {
                	count = 0;
                }
            }
        }
        
      //diagonal \   \/
        for (int val = -board[0].length; val < board[0].length; val++) {
	        count = 0;
	        for (int y = 0; y < board.length; y++) {
	            for (int x = 0; x < board[y].length; x++) {
	            	if (x == y + val) {
	            		if (board[y][x].equals(p1)) {
		                    count++;
		                    if (count == check) {
		                    	try {
			                    	if (!board[y+1][x+1].equals(p1)) {
			                    		if (x+1 != temp) return x+1;
			                    	}
		                    	} catch (ArrayIndexOutOfBoundsException e) {
		                    		try {
			                    		if (!board[y-check][x-check].equals(p1)) {
			                    			if (x-check != temp) return x-check;
				                    	}
		                    		} catch (ArrayIndexOutOfBoundsException e1) { continue; }
		                    	}
		                    }
		                } else {
		                	count = 0;
		                }
	            	}
	            }
	        }
        }

        //diagonal /   \/
        for (int val = -board.length; val < board.length; val++) {
	        count = 0;
	        for (int y = 0; y < board.length; y++) {
	            for (int x = 0; x < board[y].length; x++) {
	            	if ((board.length - 1) - x - 1 == y + val) {
	            		if (board[y][x].equals(p1)) {
		                    count++;
		                    if (count == check) {
		                    	try {
			                    	if (!board[y+1][x-1].equals(p1)) {
			                    		if (x-1 != temp) return x-1;
			                    	}
		                    	} catch (ArrayIndexOutOfBoundsException e) {
		                    		try {
			                    		if (!board[y-check][x+check].equals(p1)) {
			                    			if (x+check != temp) return x+check;
				                    	}
		                    		} catch (ArrayIndexOutOfBoundsException e1) { continue; }
		                    	}
		                    }
	            		} else {
		                	count = 0;
		                }
	            	}
	            }
	        }
        }
        
      //linhas -->
        for (int y = 0; y < board.length; y++) {
            count = 0;
            blank = 0;
            for (int x = 0; x < board[y].length; x++) {
                if (board[y][x].equals(p1)) {
                    count++;
                    if (count+blank == check) {
                    	try {
	                    	if (!board[y][x-1].equals(p) && !board[y][x-1].equals(p1)) {
	                    		if (x-1 != temp) return x-1;
		                    }else {
		                    	if (!board[y][x+1].equals(p) && !board[y][x+1].equals(p1)) if (x+1 != temp) return x+1;
		                    }
                    	} catch (ArrayIndexOutOfBoundsException e1) { continue; }
                    }
                } else {
                	count = 0;
                	if (!board[y][x].equals(p1) && !board[y][x].equals(p)) blank++;
                }
            }
        }
    	
    	//diagonal \   \/
        for (int val = -board[0].length; val < board[0].length; val++) {
	        count = 0;
	        blank = 0;
	        for (int y = 0; y < board.length; y++) {
	            for (int x = 0; x < board[y].length; x++) {
	            	if (x == y + val) {
	            		if (board[y][x].equals(p1)) {
		                    count++;
		                    try {
			                    if (count+blank == check) {
			                    	if (!board[y-2][x-2].equals(p1) && !board[y-2][x-2].equals(p)) if (x-2 != temp) return x-2;
			                    }else {
			                    	if (count+blank == check-1) if (!board[y-1][x+1].equals(p1) && !board[y-1][x+1].equals(p)) if (x+1 != temp) return x+1;
			                    }
		                    } catch (ArrayIndexOutOfBoundsException e1) { continue; }
		                } else {
		                	count = 0;
		                	if (!board[y][x].equals(p1) && !board[y][x].equals(p)) blank++;
		                }
	            	}
	            }
	        }
        }

        //diagonal /   \/
        for (int val = -board.length; val < board.length; val++) {
	        count = 0;
	        blank = 0;
	        for (int y = 0; y < board.length; y++) {
	            for (int x = 0; x < board[y].length; x++) {
	            	if ((board.length - 1) - x - 1 == y + val) {
	            		if (board[y][x].equals(p1)) {
		                    count++;
		                    try {
			                    if (count+blank == check) {
			                    	if (!board[y-2][x+2].equals(p1) && !board[y-2][x+2].equals(p)) if (x+2 != temp)  return x+2;
			                    }else {
			                    	if (count+blank == check-1) if (!board[y-1][x-1].equals(p1) && !board[y-1][x-1].equals(p)) if (x-1 != temp)  return x-1;
			                    }
		                    } catch (ArrayIndexOutOfBoundsException e1) { continue; }
		                } else {
		                	count = 0;
		                	if (!board[y][x].equals(p1) && !board[y][x].equals(p)) blank++;
		                }
	            	}
	            }
	        }
        }
    	
    	//linhas -->
        for (int y = 0; y < board.length; y++) {
            count = 0;
            for (int x = 0; x < board[y].length; x++) {
                if (board[y][x].equals(p)) {
                    count++;
                    //System.out.println(count);
                    if (count == check) {
                    	try {
	                    	if (board[y][x+1].equals(p1) || !board[y][x+1].equals(p) && !board[y][x+1].equals(p1)) {
	                    		continue;
	                    	}else {
	                    		if (x+1 != temp) return x+1;
	                    	}
                    	}catch (ArrayIndexOutOfBoundsException e){ continue; }
                    }
                } else {
                	count = 0;
                }
            }
        }
        
        //linhas <--
        for (int y = board.length-1; y >= 0 ; y--) {
            count = 0;
            for (int x = board[y].length-1; x >= 0 ; x--) {
                if (board[y][x].equals(p)) {
                    count++;
                    //System.out.println(count);
                    if (count == check) {
                    	try {
	                    	if (board[y][x-1].equals(p1) || !board[y][x-1].equals(p) && !board[y][x-1].equals(p1)) {
	                    		continue;
	                    	}else {
	                    		if (x-1 != temp) return x-1;
	                    	}
                    	}catch (ArrayIndexOutOfBoundsException e){ continue; }
                    }
                } else {
                	count = 0;
                }
            }
        }

        //colunas \/
        for (int x = 0; x < board[0].length; x++) {
        	count = 0;
            for (int y = 0; y < board.length; y++) {
                if (board[y][x].equals(p)) {
                    count++;
                    //System.out.println(count);
                    if (count == check) if (x != temp) return x;
                } else {
                	count = 0;
                }
            }
        }
        
        //diagonal \   \/
        for (int val = -board[0].length; val < board[0].length; val++) {
	        count = 0;
	        for (int y = 0; y < board.length; y++) {
	            for (int x = 0; x < board[y].length; x++) {
	            	if (x == y + val) {
	            		if (board[y][x].equals(p)) {
		                    count++;
		                    if (count == check) {
		                    	try {
			                    	if (!board[y+1][x+1].equals(p)) {
			                    		if (x+1 != temp) return x+1;
			                    	}
		                    	} catch (ArrayIndexOutOfBoundsException e) {
		                    		try {
			                    		if (!board[y-check][x-check].equals(p)) {
			                    			if (x-check != temp) return x-check;
				                    	}
		                    		} catch (ArrayIndexOutOfBoundsException e1) { continue; }
		                    	}
		                    }
		                } else {
		                	count = 0;
		                }
	            	}
	            }
	        }
        }

        //diagonal /   \/
        for (int val = -board.length; val < board.length; val++) {
	        count = 0;
	        for (int y = 0; y < board.length; y++) {
	            for (int x = 0; x < board[y].length; x++) {
	            	if ((board.length - 1) - x - 1 == y + val) {
	            		if (board[y][x].equals(p)) {
		                    count++;
		                    if (count == check) {
		                    	try {
			                    	if (!board[y+1][x-1].equals(p)) {
			                    		if (x-1 != temp) return x-1;
			                    	}
		                    	} catch (ArrayIndexOutOfBoundsException e) {
		                    		try {
			                    		if (!board[y-check][x+check].equals(p)) {
			                    			if (x+check != temp) return x+check;
				                    	}
		                    		} catch (ArrayIndexOutOfBoundsException e1) { continue; }
		                    	}
		                    }
	            		} else {
		                	count = 0;
		                }
	            	}
	            }
	        }
        }
        
        return -1;
    	
    }

}
