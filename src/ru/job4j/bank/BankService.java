package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) throws Exception {
        User user = findByPassport(passport);
        if (user == null) {
            throw new UserNotFoundException("User with passport " + passport + " not found");
        }
        List<Account> accounts = users.get(user);
        if (accounts.contains(account)) {
            throw new AccountException("You already have " + account.getRequisite() + "account");
        }
        accounts.add(account);
    }

    public User findByPassport(String passport) {
        return users.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user == null) {
            return null;
        }
        List<Account> accounts = users.get(user);
        return accounts.stream()
                .filter(account -> account.getRequisite().equals(requisite))
                .findFirst()
                .orElse(null);
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount == null || srcAccount.getBalance() < amount
            || destAccount == null) {
            return false;
        }
        destAccount.setBalance(destAccount.getBalance() + amount);
        return true;
    }
}
