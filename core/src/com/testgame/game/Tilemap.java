package com.testgame.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

public class Tilemap implements Entity {

    public LinkedList<Tile> base;
    public LinkedList<Tile> objects;
    private Texture hill;
//    private Texture water;
    private Texture grass;
    private Player player;
    public String[][] map;
    private int row;
    private int col;
    private int width;
    private int height;
    private float x;
    private float y;
    private Vector2 px;
    private Tile tile;
    private Vector2 tx;
    private Texture tt;
    private Vector2 timep;
    private Vector2 wordp;

    public Tilemap(){
        grass = new Texture("test2.png");
//        water = new Texture("water.png");
        width = grass.getWidth();
        height = grass.getHeight();
        hill = new Texture("hill.png");
        base = new LinkedList<Tile>();
        objects = new LinkedList<Tile>();
        map = new String[30][1];
        player = new Player();
        px = player.getPos();
        tile = new Tile(tt,timep,wordp);
        tx = tile.getWorldPos();
        try {
            fillmap();
            gerneretmap();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public void render(SpriteBatch batch){

        for (Tile t : base){
            t.render(batch);
        }

        for (Tile t : objects){
            t.render(batch);
        }

    }

    @Override
    public void update(float delta) throws IOException {

    }


    public  void fillmap() throws IOException{
        FileHandle fh = Gdx.files.internal("mapbase.txt");
        BufferedReader br = new BufferedReader(new FileReader(fh.path()));
        String s = "";
        int count = 0;
        while ((s = br.readLine()) != null){
//            System.out.println(s);
            map[count] = s.split(" ");
            count++;
        }
        br.close();

        Random r = new Random();
        for ( row = 29; row >= 0; row--){
            for (col = 0; col >= 0; col--){
                x = (row - col) * 64 / 2.0001f;
                y = (row + col) * 32 / 2.f;

                if (map[row][col].equals("g")){
                    base.add(new Tile(grass,new Vector2(row,col),new Vector2(x,y)));
                }
                int num = r.nextInt(100);
//                if (num > 70){
//                    objects.add(new Tile(tree,new Vector2(row,col),new Vector2(x,y)));
//                }
//                if (num > 70){
//                    objects.add(new Tile(hill,new Vector2(row,col),new Vector2(x,y+10)));
//                }
                if (map[row][col].equals("h")){
                    objects.add(new Tile(hill,new Vector2(row,col),new Vector2(x,y+10)));
                }
//                else if (map[row][col].equals("w")){
//                    base.add(new Tile(water,new Vector2(row,col),new Vector2(x,y)));
//                }
            }

        }

    }

    public void gerneretmap() throws IOException {
        FileHandle fh2 = Gdx.files.internal("mapbase2.txt");
        BufferedReader br2 = new BufferedReader(new FileReader(fh2.path()));
        String s = "";
        int count = 0;
        while ((s = br2.readLine()) != null){
//            System.out.println(s);
            map[count] = s.split(" ");
            count++;
        }
        br2.close();

        Random r = new Random();
        for ( row = 29; row >= 0; row--){
            for (int col = 0; col >= 0; col--){
                float x = (row - col) * 64 / 2.0001f;
                float y = (row + col) * 32 / 2.f;

                if (map[row][col].equals("g")){
                    base.add(new Tile(grass,new Vector2(row,col),new Vector2(x+960,y+480)));
                }
                int num = r.nextInt(100);
//                if (num > 70){
//                    objects.add(new Tile(tree,new Vector2(row,col),new Vector2(x,y)));
//                }
                if (map[row][col].equals("h")){
                    objects.add(new Tile(hill,new Vector2(row,col),new Vector2(x+960,y+490)));
                }
//                else if (map[row][col].equals("w")){
//                    base.add(new Tile(water,new Vector2(row,col),new Vector2(x,y)));
//                }
            }

        }
    }

}
