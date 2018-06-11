package com.vargo.vdk.example;

/**
 * <br/>
 * <li>Author Cesc Shang
 * <li>Email shanghaolongteng@vargo.com.cn
 * <li>Date 2018/06/07 16:49
 */
public class Entity {
    private boolean success;
    private String path;
    private int width, height;

    public static Entity getSuccessEntity(String path, int width, int height) {
        return new Entity(true, path, width, height);
    }

    public static Entity getFiledEntity() {
        Entity e = new Entity();
        e.setSuccess(false);
        return e;
    }

    public Entity() {
    }

    public Entity(boolean success, String path, int width, int height) {
        this.success = success;
        this.path = path;
        this.width = width;
        this.height = height;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
