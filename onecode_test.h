
#include <bits/stdc++.h>
#include <iostream>
#include <ostream>
#include <vector>
using namespace std;

/*
    If we have something like a org tree of a company where we have tree like structure which represents the total number of employees directly reporting to him and then if we scroll further each branch further expands to   the employees reporting to the current employee and so on.
Find the total number of direct repotees of a given manager. (Not the total employees under him but the direct ones).

eg1:
                    a
                b.      c.   d. e
            f     g.    i.   j


    count(direct/reportee/ a)=  4
    count(b) = 2
    count(e) =0
    f,g,i, j= 0



    a--> b
    a--> c
    a-->d
    a--> e

b-> f
b-->g


Solution : name of her person==> search --> this node ---> O(n) ===> reference to this node ===> get its chldren  (get all its refrences ) ==O(1)

name of her person==> search --> this node ---> O(n) ===> reference to this node


searching

dfs/bfs


dfs:
dfs :

()
dfs(int person, node * par){

if (null)
    return -1;
if curre== person)
    return crr // par
else
    chldren= getchildren(cur)  vector<children> [b, c, d,e ]
    pick one child  //
    dfs(child, cur );

}


1. find dir manager

2. find common manager  (f, j) =a ==> least common ancestor
lca

n - ary tree ka lca
 bianry tree lca

       a
    b     c
  d   e



lca(d,e)== b
lca(d,c)= a


b---> left
<--
b---.e
<---
curr lca



x, y

cur

left x
right y
cur

left



lca (x,y)










DS:

                        a
                b.      c.   d. e
            f     g.    i.   j


a -> b
a -> c
a -> d


a---> vector<children> [b, c, d,e ]



b--- > vector<kids> [f,g]






*/

class Node{
public:
    string name;
    vector<Node* > childfren;

    Node(char c, vector<<Node*> kids){
        this->name= c;
        this->children = kids;
    }
};



int getCount(char n, Node * root){
    //Base
    if (root == nullptr){
        return  -1;
    }
    if(root->name == n){
        return  root->childfren.size();
    }else{
        auto kids= root->childfren;
        for (auto kid: kids ){
            getCount(n, kid);
        }
    }

}

int solution(string s) {
    vector<Node *> kids;
    Node * node = new Node("b", nullptr );//TODO:
    kids.push_back(node);
    node = new Node("c", nullptr);
    kids.push_back(node);
    node = new Node("d", nullptr);
    kids.push_back(node);
    node = new Node("e", nullptr);
    kids.push_back(node);
    Node * root= = new Node("a", kids );
    char name= "a";

    int ans = getCount(name, root);
    cout<<"dirct reortees are "<<ans<<endl;

}

int main()
{
    string s;
    cin >> s;
    cout << solution(s);
}

#include <iostream>
#include <bits/stdc++.h>
using namespace std;
/*
  Given an array of integers nums, calculate the pivot index of this array.

  The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.

  If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.

  Return the leftmost pivot index. If no such index exists, return -1.

  Input: nums = [1,7,3,6,5,6]
  Output: 3
  Explanation:
  The pivot index is 3.
  Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
  Right sum = nums[4] + nums[5] = 5 + 6 = 11

Input: nums = [1,7,3,6,5,6]


[1] ==> [0, 0]


          [1,    7,   3,  6,   5,  6. ]

left sum.   0        1     8      11      17.  22   = O(n)

right sum.   27      20    17     11       6    0.  = O(n)


O(n)

space:O(n)














*/
int solution(vector<int> v) {
    // write the solution here..

    for(int i= 0; )
}

int main()
{
    string s;
    cin >> s;
    cout << solution(s);
}