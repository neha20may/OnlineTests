// Compiled with: g++ -Wall -std=c++14 -pthread

#include <iostream>
#include <vector>

using namespace std;

class Solution{
public:
    int getProfit(vector<int> &stocks){

        if(stocks.size()==0)
            return 0;
        if(stocks.size()==1)
            return 0;

        int minFar= stocks[0];
        int maxFar=0;
        int profit =0;

        for (int i=1; i< stocks.size(); i++){
            if(stocks[i] > minFar){
                profit = max( profit, stocks[i]- minFar) ;

            }
            else{
                minFar= stocks[i];
            }

        }
        return profit;
    }
};

int main(){
    cout<<"hi"<<endl;
    vector<int> v= {2, 6, 1, 3, 10};
    Solution s;
    int profit = s.getProfit(v);
    cout<<"profit is="<<profit<<endl;
    return 0;
}


