// 第一版Union-Find
// 使用数组模拟集合
public class UnionFind1 implements UF {

    private int[] id;

    public UnionFind1(int size) {
        id = new int[size];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    // 查找元素p所对应的集合编号
    // O(1)复杂度
    private int find(int p) {
        if (p < 0 || p >= id.length)
            throw new IllegalArgumentException("p is out of bound.");

        return id[p];
    }

    @Override
    public int getSize() {
        return id.length;
    }

    // 查看元素p和元素q是否所属一个集合
    // O(1)复杂度
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // 合并元素p和元素q所属的集合
    // O(n) 复杂度
    @Override
    public void unionElements(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if(pId == qId) {
            return;
        }

        // 合并过程需要遍历一遍所有元素, 将两个元素的所属集合编号合并
        // 也可以把所有 qId 改成 pId
        for(int i = 0; i < id.length; i++) {
            if(id[i] == pId) {
                id[i] = qId;
            }
        }

    }
}
