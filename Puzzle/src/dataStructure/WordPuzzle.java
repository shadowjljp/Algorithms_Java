package dataStructure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordPuzzle {

	public int loadDictionary(QuadraticProbingHashTable HT, int wordCount, String path, boolean isEnhanced) {
		Scanner s1 = null;
		try {
			s1 = new Scanner(new File(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (s1.hasNext()) {
			String word = s1.nextLine();
			if (isEnhanced) {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < word.length(); i++) {
					sb.append(word.charAt(i));
					if (i == word.length() - 1) {
						HT.insert(sb.toString(), true);
						wordCount++;
					} else {
						HT.insert(sb.toString(), false);
					}
				}
			} else {
				HT.insert(word, true);
				wordCount++;

			}
		}
		s1.close();
		return wordCount;
	}

	public void checkHorizontalWE(QuadraticProbingHashTable<String> HT, ArrayList<String> results, char puzzle[][],
			boolean isEnhanced) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<puzzle.length;i++) {
			
			for( int j=0;j<puzzle[i].length;j++) {
				sb.setLength(0);
				for(int k=j;j+k<puzzle[i].length;k++) {
					sb.append(puzzle[i][j+k]);
					boolean contain = HT.contains(sb.toString());
					if(!contain&& isEnhanced==true) {
						sb.setLength(0);
						break;
					}else if(contain) {
						results.add(sb.toString());
					
					}
					
				}
			}
		}
	}
	
	public void checkHorizontalEW(QuadraticProbingHashTable<String> HT, ArrayList<String> results, char puzzle[][],
			boolean isEnhanced) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<puzzle.length;i++) {
			
			for( int j=puzzle[i].length-1;j>-1;j--) {
				sb.setLength(0);
				for(int k=j;k<-1;k--) {
					sb.append(puzzle[i][k]);
					boolean contain = HT.contains(sb.toString());
					if(!contain&& isEnhanced==true) {
						sb.setLength(0);
						break;
					}else if(contain) {
						results.add(sb.toString());
					
					}
					
				}
			}
		}
	}
	public void checkDiagonalNS(QuadraticProbingHashTable<String> HT, ArrayList<String> results, char puzzle[][],
			boolean isEnhanced) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<puzzle[0].length;i++) {
			
			for( int j=0;j<puzzle.length;j++) {
				sb.setLength(0);
				for(int k=j;j+k<puzzle.length;k++) {
					sb.append(puzzle[k+j][i]);
					boolean contain = HT.contains(sb.toString());
					if(!contain&& isEnhanced==true) {
						sb.setLength(0);
						break;
					}else if(contain) {
						results.add(sb.toString());
					
					}
					
				}
			}
		}
	}
	public void checkDiagonalSN(QuadraticProbingHashTable<String> HT, ArrayList<String> results, char puzzle[][],
			boolean isEnhanced) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<puzzle[0].length;i++) {
			
			for( int j=0;j<puzzle.length;j++) {
				sb.setLength(0);
				for(int k=puzzle.length-1;k-j<-1;k--) {
					sb.append(puzzle[i][k]);
					boolean contain = HT.contains(sb.toString());
					if(!contain&& isEnhanced==true) {
						sb.setLength(0);
						break;
					}else if(contain) {
						results.add(sb.toString());
					
					}
					
				}
			}
		}
	}
	public void checkDiagonalNE(QuadraticProbingHashTable<String> HT, ArrayList<String> results, char puzzle[][],
			boolean isEnhanced) {
		StringBuilder sb = new StringBuilder();
//		int diagonal =(int) Math.sqrt(Math.pow(puzzle.length, 2)+Math.pow(puzzle[0].length, 2));
		for(int i=0;i<puzzle.length;i++) {  //row 0 will not have NE
			
			for( int j=0;j<puzzle[0].length;j++) {
				sb.setLength(0);
				int m =i;
				for(int k=j;k<puzzle[0].length;k++) {
					
					sb.append(puzzle[m][k]);
					boolean contain = HT.contains(sb.toString());
					if(!contain&& isEnhanced==true) {
						sb.setLength(0);
						break;
					}else if(contain) {
						results.add(sb.toString());
					
					}
					
					m--;
					if (m<0) {
						break;
					}
				}
			}
		}
	}
	public void checkDiagonalNW(QuadraticProbingHashTable<String> HT, ArrayList<String> results, char puzzle[][],
			boolean isEnhanced) {
		StringBuilder sb = new StringBuilder();
//		int diagonal =(int) Math.sqrt(Math.pow(puzzle.length, 2)+Math.pow(puzzle[0].length, 2));
		for(int i=0;i<puzzle.length;i++) {  //row 0 will not have NE
			
			for( int j=0;j<puzzle[0].length;j++) {
				sb.setLength(0);
				int m =i;
				for(int k=j;k>0;k--) {
					
					sb.append(puzzle[m][k]);
					boolean contain = HT.contains(sb.toString());
					if(!contain&& isEnhanced==true) {
						sb.setLength(0);
						break;
					}else if(contain) {
						results.add(sb.toString());
					
					}
					
					m--;
					if (m<0) {
						break;
					}
				}
			}
		}
	}
	public void checkDiagonalSE(QuadraticProbingHashTable<String> HT, ArrayList<String> results, char puzzle[][],
			boolean isEnhanced) {
		StringBuilder sb = new StringBuilder();
//		int diagonal =(int) Math.sqrt(Math.pow(puzzle.length, 2)+Math.pow(puzzle[0].length, 2));
		for(int i=0;i<puzzle.length;i++) {  //row 0 will not have NE
			
			for( int j=0;j<puzzle[0].length;j++) {
				sb.setLength(0);
				int m =i;
				for(int k=j;k<puzzle[0].length;k++) {
					
					sb.append(puzzle[m][k]);
					boolean contain = HT.contains(sb.toString());
					if(!contain&& isEnhanced==true) {
						sb.setLength(0);
						break;
					}else if(contain) {
						results.add(sb.toString());
					
					}
					
					m++;
					if (m>puzzle[0].length-1) {
						break;
					}
				}
			}
		}
	}
	public void checkDiagonalSW(QuadraticProbingHashTable<String> HT, ArrayList<String> results, char puzzle[][],
			boolean isEnhanced) {
		StringBuilder sb = new StringBuilder();
//		int diagonal =(int) Math.sqrt(Math.pow(puzzle.length, 2)+Math.pow(puzzle[0].length, 2));
		for(int i=0;i<puzzle.length;i++) {  //row 0 will not have NE
			
			for( int j=0;j<puzzle[0].length;j++) {
				sb.setLength(0);
				int m =i;
				for(int k=j;k>-1;k--) {
					
					sb.append(puzzle[m][k]);
					boolean contain = HT.contains(sb.toString());
					if(!contain&& isEnhanced==true) {
						sb.setLength(0);
						break;
					}else if(contain) {
						results.add(sb.toString());
					
					}
					
					m++;
					if (m>puzzle[0].length-1) {
						break;
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		
		int wordCount = 0;
		int rows =0;
		int columns=0;
		// dictionary location
		// String path ="E:\\UTD data
		// structure\\Puzzle\\src\\dataStructure\\dictionary.txt";
		String path = "dictionary.txt";
		boolean isEnhanced = false;

		QuadraticProbingHashTable HT = new QuadraticProbingHashTable();
		WordPuzzle wordPuzzle = new WordPuzzle();
		Scanner sc;
		while(true) {
			//setting up puzzle part 
			 sc = new Scanner(System.in);
			System.out.println("Please enter number of rows and columns ");
			try {
				
				 rows = sc.nextInt();
				 columns = sc.nextInt();
				 break;
			}catch(Exception e) {
				System.out.println("rows and columns must be positive number");
				
			}
		}
		while(true) {
			//enhancement or not
			System.out.println("enter t to open enhancement or f to close enhancement");
			String switcher = sc.next();
			if(switcher.equals("t")) {
				isEnhanced = true;
				break;
			}else if(switcher.equals("f")) {
				isEnhanced = false;
				break;
			}
		}
		sc.close();
		
		if(rows>0 || columns >0) {
			char[][] puzzle = new char[rows][columns];
			Random random = new Random();
			for(int i=0;i<rows;i++) {
				for( int j =0;j<columns;j++) {
					//fill random lower case char in the puzzle
					puzzle[i][j] = (char)(97+random.nextInt(26));
				}
			}
			//show puzzle
			System.out.println("-------------------------------------------");
			for(int i=0;i<puzzle.length;i++) {
				for( int j =0;j<puzzle[0].length;j++) {
					System.out.print(puzzle[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println("-------------------------------------------");
			
			//load dictionary
			wordCount = wordPuzzle.loadDictionary(HT, wordCount, path, isEnhanced);
			System.out.println("Dictionary has " + wordCount + " words ");
			//search for words in puzzle
			ArrayList<String> results = new ArrayList<String>();
			long startTime = System.currentTimeMillis();
			wordPuzzle.checkDiagonalNS(HT, results, puzzle, isEnhanced);
			wordPuzzle.checkDiagonalSN(HT, results, puzzle, isEnhanced);
			wordPuzzle.checkHorizontalWE(HT, results, puzzle, isEnhanced);
			wordPuzzle.checkHorizontalEW(HT, results, puzzle, isEnhanced);
			wordPuzzle.checkDiagonalNE(HT, results, puzzle, isEnhanced);
			wordPuzzle.checkDiagonalNW(HT, results, puzzle, isEnhanced);
			wordPuzzle.checkDiagonalSW(HT, results, puzzle, isEnhanced);
			wordPuzzle.checkDiagonalSE(HT, results, puzzle, isEnhanced);
			long endTime = System.currentTimeMillis();
			long result = endTime-startTime;
			System.out.println("-------------------------------------------");
			System.out.println("word found ");
			for(String re:results) {
				System.out.println(re+" ");
			}
			System.out.println("Amount of words have been found: "+results.size());
			System.out.println("Total time taken "+result+"ms");
		}
	}

}
