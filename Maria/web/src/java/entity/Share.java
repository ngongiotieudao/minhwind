/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author kynhanht
 */
public class Share {
    private String icon,socialNetwork,url;

    public Share() {
    }

    public Share(String icon, String socialNetWork, String url) {
        this.icon = icon;
        this.socialNetwork = socialNetWork;
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getSocialNetwork() {
        return socialNetwork;
    }

    public void setSocialNetwork(String socialNetWork) {
        this.socialNetwork = socialNetWork;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}
