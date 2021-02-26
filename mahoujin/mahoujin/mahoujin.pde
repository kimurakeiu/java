int [][] square = {{0, 11, 5, 14}, {7, 12, 2, 9}, {10, 1, 15, 4}, {13, 6, 8, 3}};
int [] buffer = new int[4];


class Frame{
  int x, y;
  int s;
  int k;
  
  Frame(int x, int y, int s, int k){
    this.x = x;
    this.y = y;
    this.s = s;
    this.k = k;
  }
  
  void display_fra(){
    pushMatrix();
    fill(125, 97, 75);
    translate(x, y);
    noStroke();
    rect(0, 0, s, s);
    translate(s/2, s/2);
    rotate(k*PI/2);
    translate(-s/2, -s/2);
    stroke(167, 141, 115);
    strokeWeight(2);
    strokeCap(ROUND);
    arc(0, 0, s, s, 0, PI/2);
    arc(s, s, s, s, PI, 3*PI/2);
    popMatrix();
  }
}


void setup(){
  size(1440, 900);
  noLoop();
  stroke(255);
  background(232, 232, 228);
}


void draw(){
  translate(width/2, height/2);

  //frame
  pushMatrix();
  stroke(119, 85, 85);
  strokeWeight(5);
  fill(167, 141, 115);
  rect(-205, -255, 410, 510);
  popMatrix();
  pushMatrix();
  translate(-200, -250);
  for(int i=0; i<25; i++){
    for(int j=0; j<20; j++){
      int k = int(random(0, 4));
      Frame frame = new Frame(j*20, i*20, 20, k);
      frame.display_fra();
    }
  }
  popMatrix();
  pushMatrix();
  fill(250);
  rect(-185, -235, 370, 470);
  popMatrix();
  
  //juice
  allocate();
}
    
    
void shiftH(){
  for(int j=0; j<4; j++){
    buffer[j] = square[0][j];
  }
  for(int i=1; i<4; i++){
    for(int j=0; j<4; j++){
      square[i-1][j] = square[i][j];
    }
  }
  for(int j=0; j<4; j++){
    square[3][j] = buffer[j];
  }
}


void shiftV(){
  for(int i=0; i<4; i++){
    buffer[i] = square[i][0];
  }
  for(int j=1; j<4; j++){
    for(int i=0; i<4; i++){
      square[i][j-1] = square[i][j];
    }
  }
  for(int i=0; i<4; i++){
    square[i][3] = buffer[i];
  }
}


void allocate(){
  
  //icecream
  pushMatrix();
  translate(-40, -120);
  for(int l=0; l<5; l++){
    display_ice();
    shiftH();
    translate(20, 0);
  }
  translate(-95, -10);
  display_ice();
  shiftH();
  translate(20, 0);
  display_ice();
  shiftH();
  translate(20, 0);
  display_ice();
  shiftH();
  translate(20, 0);
  display_ice();
  shiftH();
  translate(10, 0);
  display_ice();
  shiftH();
  translate(-65, -5);
  for(int l=0; l<4; l++){
    display_ice();
    shiftH();
    translate(20, 0);
  }
  translate(-75, -5);
  display_ice();
  shiftH();
  translate(20, 0);
  display_ice();
  shiftH();
  translate(20, 0);
  display_ice();
  shiftH();
  translate(10, 0);
  display_ice();
  shiftH();
  translate(-40, -5);
  display_ice();
  shiftH();
  translate(20, 0);
  display_ice();
  shiftH();
  translate(10, 0);
  display_ice();
  shiftH();
  translate(-20, -5);
  display_ice();
  shiftH();
  translate(10, 0);
  display_ice();
  shiftH();
  
  //cherry
  translate(-60, 20);
  display_che();
  shiftH();
  translate(5, 0);
  display_che();
  shiftH();
  translate(0, -5);
  display_che();
  shiftH();
  translate(5, 5);
  display_che();
  shiftH();
  fill(80, 108, 70);
  rect(-25, -20, 4, 4);
  rect(-20, -15, 4, 4);
  rect(-15, -10, 4, 4);
  popMatrix();
  
  //top
  translate(-80, -110);
  display_top();
  shiftV();
  translate(5, 20);
  display_top();
  shiftV();
  translate(130, 0);
  display_top();
  shiftV();
  translate(5, -20);
  display_top();
  shiftV();
  translate(-130, 0);
  for(int l=0; l<7; l++){
    for(int m=0; m<3; m++){
      display_top();
      shiftV();
      translate(0, 20);
    }
    shiftH();
    translate(20, -60);
  }
  
  //middle
  translate(-140, 60);
  for(int l=0; l<7; l++){
    for(int m=0; m<4; m++){
      display_mid();
      shiftV();
      translate(0, 20);
    }
    shiftH();
    translate(20, -80);
  }
  translate(-145, 40);
  display_mid();
  shiftV();
  translate(-5, 20);
  display_mid();
  shiftV();
  translate(140, 0);
  display_mid();
  shiftV();
  translate(-5, -20);
  display_mid();
  shiftV();
  
  //bottom
  translate(-135, 40);
  for(int l=0; l<8; l++){
    for(int m=0; m<2; m++){
      display_bot();
      shiftV();
      translate(0, 20);
    }
    shiftH();
    translate(20, -40);
  }
  translate(-150, 40);
  for(int l=0; l<7; l++){
    display_bot();
    shiftH();
    translate(20, 0);
  }
  translate(-130, 10);
  for(int l=0; l<6; l++){
    display_bot();
    shiftH();
    translate(20, 0);
  }
  translate(-110, 10);
  for(int l=0; l<5; l++){
    display_bot();
    shiftH();
    translate(20, 0);
  }
  translate(-80, 10);
  for(int l=0; l<3; l++){
    display_bot();
    shiftH();
    translate(20, 0);
  }
  translate(-115, -70);
  display_bot();
  shiftV();
  translate(25, -5);
  display_mid();
  shiftV();
  translate(35, 0);
  display_mid();
  shiftV();
  translate(35, 0);
  display_mid();
  shiftV();
  translate(35, 0);
  display_mid();
  shiftV();
  translate(20, 5);
  display_bot();
  shiftV();
  translate(-35, 0);
  display_bot();
  shiftV();
  translate(-40, 0);
  display_bot();
  shiftV();
  translate(-35, 0);
  display_bot();
  shiftV();
  translate(-30, 30);
  display_bot();
  shiftV();
  translate(130, 0);
  display_bot();
  shiftV();
  translate(-35, 35);
  display_bot();
  shiftV();
  translate(-60, 0);
  display_bot();
  shiftV();
    
  //glass
  translate(25, 25);
  for(int l=0; l<2; l++){
    for(int m=0; m<4; m++){
      display_gla();
      shiftV();
      translate(0, 20);
    }
    shiftH();
    translate(10, -80);
  }
  translate(-75, 60);
  for(int l=0; l<7; l++){
    display_gla();
    shiftH();
    translate(20, 0);
  }
  translate(-110, -10);
  for(int l=0; l<4; l++){
    display_gla();
    shiftH();
    translate(20, 0);
  }
  translate(-5, 5);
  display_gla();
  shiftV();
  translate(-90, 0);
  display_gla();
  shiftV();
  translate(35, -10);
  display_gla();
  shiftV();
  translate(20, 0);
  display_gla();
  shiftV();
}


void display_top(){
  for(int i=0; i<4; i++){
    for(int j=0; j<4; j++){
      float cl = map(square[i][j], 0, 15, 0, 30);
      fill(90+2*cl, 170+cl, 90+2*cl);
      noStroke();
      rect(j*5, i*5, 4, 4);
    }
  }
}


void display_mid(){
  for(int i=0; i<4; i++){
    for(int j=0; j<4; j++){
      float cl = map(square[i][j], 0, 15, 0, 30);
      fill(140+2*cl, 180+cl, 140+2*cl);
      noStroke();
      rect(j*5, i*5, 4, 4);
    }
  }
}


void display_bot(){
  for(int i=0; i<4; i++){
    for(int j=0; j<4; j++){
      float cl = map(square[i][j], 0, 15, 0, 30);
      fill(180+2*cl, 200+cl, 140+2*cl);
      noStroke();
      rect(j*5, i*5, 4, 4);
    }
  }
}


void display_gla(){
  for(int i=0; i<4; i++){
    for(int j=0; j<4; j++){
      fill(201, 215, 235);
      noStroke();
      rect(j*5, i*5, 4, 4);
    }
  }
}


void display_ice(){
  for(int i=0; i<4; i++){
    for(int j=0; j<4; j++){
      float cl = map(square[i][j], 0, 15, 0, 15);
      fill(225+cl, 225+cl, 205+cl);
      noStroke();
      rect(j*5, i*5, 4, 4);
    }
  }
}


void display_che(){
  for(int i=0; i<4; i++){
    for(int j=0; j<4; j++){
      float cl = map(square[i][j], 0, 15, 0, 15);
      fill(175+cl, cl, 15+cl);
      noStroke();
      rect(j*5, i*5, 4, 4);
    }
  }
}


void keyPressed(){
  if(key == 'p') {
    saveFrame("midori.jpg");
  }
  if(key == 'v'){
    shiftV();
  }
  else if(key == 'h'){
    shiftH();
  }
  redraw();
}    
