package com.example.algorithmdemo.a0630.a100分新加题21;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: a14五子棋迷_100_双指针
 * @desc:  Todo
 * https://blog.csdn.net/qfc_128220/article/details/130766999
题目描述：
张兵和王武是五子棋迷，工作之余经常切磋棋艺。这不，这会儿又下起来了。走了一会儿，轮张兵了，对着一条线思考起来了，这条线上的棋子分布如下:
用数组表示: -1 0 1 1 1 0 1 0 1 -1
棋子分布说明:
-1代表白子，0代表空位，1 代表黑子
数组长度L，满足 1 < L < 40，L为奇数
你得帮他写一个程序，算出最有利的出子位置。 最有利定义：
找到一个空位(0)，用棋子(1/-1)填充该位置，可以使得当前子的最大连续长度变大
如果存在多个位置，返回最靠近中间的较小的那个坐标
如果不存在可行位置，直接返回-1
连续长度不能超过5个(五字棋约束)
输入描述：
第一行: 当前出子颜色
第二行: 当前的棋局状态
输出描述：
1个整数，表示出子位置的数组下标

用例：
输入
1
-1 0 1 1 1 0 1 -1 1
输出
5
说明
当前为黑子 (1)，放置在下标为5的位置，黑子的最大连续长度，可以由3到5

输入
-1
-1 0 1 1 1 0 1 0 1 -1 1
输出
1
说明
当前为白子，唯一可以放置的位置下标为1，白子的最大长度，由1变为2

输入
1
0 0 0 0 1 0 0 0 0 1 0
输出
5
说明
可行的位置很多，5最接近中间的位置坐标

public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

int color = Integer.parseInt(sc.nextLine());
int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

System.out.println(getResult(color, nums));
}

public static int getResult(int color, int[] nums) {
// 获取初始的最大连续长度
int initMaxConstantLen = getInitMaxConstantLen(color, nums);

ArrayList<int[]> ans = new ArrayList<>();

// l~r之间必须且只能包含一个0，即必须落子一次，其余都是color颜色的棋子
int l = 0;
int r = 0;

// l~r之间包含的0的数量，即落子数量
int zero = 0;
// l~r之间0的位置，即落子位置
int pos = -1;

while (r < nums.length) {
// 如果nums[r]是空位
if (nums[r] == 0) {
// 则可以落子，因此落子个数++
zero++;

// 如果落子数量超过1个了，则此时 l~r-1 范围就是一个连棋(PS:r位置不算在内)，
// 如果该连棋长度 (r-1) - l + 1 <= 5（PS:五字棋约束），则是一个合法的连棋
// 本题要求落子可以使得当前子的最大连续长度变大
if (zero > 1 && r - l <= 5 && r - l > initMaxConstantLen) {
ans.add(new int[] {pos, r - l}); // 记录 l~r-1 范围的落子位置pos，以及连续长度r-l
}

// 由于只能落子一次，因此前面的落子需要收回，即更新 l 到上一次落子位置的右边
if (zero > 1) {
zero--;
l = pos + 1;
}

// 更新落子位置
pos = r;

++r;
}
// 如果nums[r]位置有其他颜色棋子，则连棋中断
else if (nums[r] != color) {
// 此时需要检查 l~r-1 范围是否落过子，且是否符合五子棋约束
// 若是，则记录 l~r-1 范围的落子位置pos，以及连续长度r-l
// 本题要求落子可以使得当前子的最大连续长度变大
if (zero == 1 && r - l <= 5 && r - l > initMaxConstantLen) ans.add(new int[] {pos, r - l});
// 由于连棋中断了，因此落子位置pos，和落子数量全部重置
pos = -1;
zero = 0;
// l,r全部更新到当前r的右边一个位置
l = ++r;
}
// 如果nums[r]位置有当前颜色棋子，则连棋继续
else {
++r;
}
}

// 收尾操作
if (zero == 1 && r - l <= 5 && r - l > initMaxConstantLen) {
ans.add(new int[] {pos, r - l});
}

// 如果没有统计到连棋情，则返回-1
if (ans.size() == 0) return -1;

int mid = nums.length / 2;

// 如果统计到连棋
// 先按照连棋长度降序，如果长度相同，则按照接近中心位置mid的距离升序（越近的越优），如果距离中心位置mid相同，则按照落子位置升序（越小的越优）
ans.sort((a, b) -> a[1] != b[1] ? b[1] - a[1] : cmp(a[0], b[0], mid));
return ans.get(0)[0]; // 取最优情况的落子位置
}

// 比较pos1,pos2谁更接近mid，如果距离mid相同，则返回较小的
public static int cmp(int pos1, int pos2, int mid) {
int dis1 = Math.abs(pos1 - mid);
int dis2 = Math.abs(pos2 - mid);

if (dis1 != dis2) {
return dis1 - dis2;
} else {
return pos1 - pos2;
}
}

// 获取初始最大连续长度，即未落子前的最大连续长度
public static int getInitMaxConstantLen(int color, int[] nums) {
int maxLen = 0;

int len = 0;
for (int num : nums) {
if (num != color) {
maxLen = Math.max(maxLen, len);
len = 0;
} else {
len++;
}
}

return Math.max(maxLen, len);
}

 * @date: 2023/6/4 8:31
 * @version: V-1.0
 */
public class a14五子棋迷_100_双指针 {
}
