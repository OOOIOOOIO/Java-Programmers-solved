package kakao2019BLIND_RECURITMENT;

import java.util.*;
import java.util.regex.*;

public class 매칭점수 {

    public int solution(String word, String[] pages) {
        int numOfPages = pages.length;

        Map<String, Page> pageData = new HashMap<>();
        Map<String, List<String>> pageLink = new HashMap<>();
        Pattern pageUrlPattern = Pattern.compile("<meta property=\"og:url\" content=\"(\\S*)\"");
        Pattern outUrlPattern = Pattern.compile("<a href=\"(\\S*)\"");
        Pattern wordPattern = Pattern.compile("\\b(?i)"+word+"\\b");
        Matcher matcher;
        String home = "";
        String body = "";
        for (int i = 0; i < numOfPages; i++) {
            String page = pages[i];
            matcher = pageUrlPattern.matcher(page);
            if (matcher.find()) {
                home = matcher.group(1);
            }

            matcher = outUrlPattern.matcher(page);
            List<String> urlList = new ArrayList<>();
            while (matcher.find()) {
                String out = matcher.group(1);
                urlList.add(out);
            }
            pageLink.put(home, urlList);

            body = page.split("<body>")[1];
            body = body.split("</body>")[0].replaceAll("[0-9]", " ");

            matcher = wordPattern.matcher(body.toLowerCase());
            int basicScore = 0;
            while (matcher.find()) {
                basicScore++;
            }

            pageData.put(home,
                    new Page(i, ((double) basicScore / pageLink.get(home).size()), basicScore));
        }

        for (String key : pageLink.keySet()) {
            Page posPage = pageData.get(key);
            for (String out : pageLink.get(key)) {
                if(pageData.containsKey(out)) {
                    Page outPage = pageData.get(out);
                    outPage.total += posPage.out;
                }
            }
        }

        List<Page> res = new ArrayList<>(pageData.values());
        Collections.sort(res);
        return res.get(0).idx;
    }

    static class Page implements Comparable<Page> {
        int idx;
        double out;
        double total;

        public Page(int idx,double out, double total) {
            this.idx = idx;
            this.out = out;
            this.total = total;
        }

        @Override
        public int compareTo(Page o) {
            double a = o.total-this.total;
            if(a==0) {
                return Integer.compare(this.idx, o.idx);
            }else {
                return Double.compare(o.total, this.total);
            }
        }
    }

    public static void main(String[] args) {



    }


}
