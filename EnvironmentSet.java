package breakbrick;

public interface EnvironmentSet {
	static final int TIMEDELAY = 10; // timer action발동 주기
	
	static final int MAPWIDTH = 900; //화면의 x축 크기
	static final int MAPHEIGHT= 700; //화면의 y축 크기
	
	static final int BALLSIZE = 25; // 볼의 크기
	static final int BALLSPEED = 5; // 볼의 속도

	static final int XBARSIZE  = 150; // bar의 넓이
	static final int YBARSIZE  = 25; // bar의 길이
	static final int BARSPEED = 40; // bar의 속도
	
	static final int XBRICKSIZE = 100; // brick넓이
	static final int YBRICKSIZE = 20; // brick 높이
}
