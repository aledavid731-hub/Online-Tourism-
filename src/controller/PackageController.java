package controller;

import model.Package;
import model.PackageDAO;

import java.util.List;

public class PackageController {

    PackageDAO dao = new PackageDAO();

    public List<Package> getAllPackages() {
        return dao.getAllPackages();
    }

    public Package getPackage(int id) {
        return dao.getPackageById(id);
    }
}