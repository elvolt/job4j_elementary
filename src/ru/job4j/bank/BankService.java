package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) throws Exception {
        Optional<User> user = findByPassport(passport);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User with passport " + passport + " not found");
        }
        List<Account> accounts = users.get(user.get());
        if (accounts.contains(account)) {
            throw new AccountException("You already have " + account.getRequisite() + "account");
        }
        accounts.add(account);
    }

    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isEmpty()) {
            return Optional.empty();
        }
        List<Account> accounts = users.get(user.get());
        return accounts.stream()
                .filter(account -> account.getRequisite().equals(requisite))
                .findFirst();
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isEmpty() || destAccount.isEmpty()
                || srcAccount.get().getBalance() < amount) {
            return false;
        }
        destAccount.get().setBalance(destAccount.get().getBalance() + amount);
        return true;
    }
}
